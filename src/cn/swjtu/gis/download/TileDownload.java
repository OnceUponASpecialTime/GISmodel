package cn.swjtu.gis.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by Foutas on 2017/6/19.
 */
public class TileDownload {

    private static final String url_address = "http://online1.map.bdimg.com/tile/"; //?qt=tile&x=835&y=308&z=12&styles=pl&scaler=2&udt=20160202";
    private static final String path_store = "D:\\Ccode\\tiles\\";
    //对应参数z，一级目录
    private static final int[] level = {5,6,7,8,9,10,11,12};
    //对应参数y，二级目录
    private static final int[] x1 = {1,2,3,4,5,6,7};
    private static final int[] x2 = {7,8,9,10,11,12,13,14};
    private static final int[] x3 = {15,16,17,18,19,20,21,22,23,24,25,26,27,28};
    private static final int[] x4 = {50,51,52,53,54};
    private static final int[] x5 = {102,103,104,105,106,107,108,109};
    private static final int[] x6 = {204,205,206,207,208,209,210,211,212,213,214,215,216};
    private static final int[] x7 = {413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,
    435,436,437,438,439,440,441,442,443,444,445,446};
    //对应参数x，图片名称
    private static final int[] y1 = {1,2,3};
    private static final int[] y2 = {1,2,3,4,5,6};
    private static final int[] y3 = {4,5,6,7,8,9,10,11,12,13};
    private static final int[] y4 = {17,18,19,20,21,22,23};
    private static final int[] y5 = {35,36,37,38,39,40,41,42,43,44,45,46};
    private static final int[] y6 = {70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
    private static final int[] y7 = {149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,164,166,167,168,169,
    170,171,172,173,174,175,176,177,178,179,180};


    public static void main(String[] args) {
        Map<Integer, int[]> map1 = new HashMap<>();
        Map<Integer, int[]> map2 = new HashMap<>();
        map1.put(level[0], x1);
        map1.put(level[1], x2);
        map1.put(level[2], x3);
        map1.put(level[3], x4);
        map1.put(level[4], x5);
        map1.put(level[5], x6);
        map1.put(level[6], x7);

        map2.put(level[0], y1);
        map2.put(level[1], y2);
        map2.put(level[2], y3);
        map2.put(level[3], y4);
        map2.put(level[4], y5);
        map2.put(level[5], y6);
        map2.put(level[6], y7);

        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < map1.get(level[i]).length; j++) {
                for (int k = 0; k < map2.get(level[i]).length; k++) {
                    String url = url_address + "?qt=tile&x="+map1.get(level[i])[j] + "&y=" +map2.get(level[i])[k] +
                            "&z=" + level[i] + "&styles=pl&scaler=2&udt=20160202";
                    String fielname = String.valueOf(map2.get(level[i])[k]) + ".jpg";
                    String path = path_store + String.valueOf(level[i]) + "\\" + String.valueOf(map1.get(level[i])[j]);
                    download(url, fielname ,path);
                }
            }
        }
    }

    /**
     *
     * @param url 图片地址
     * @param filename 图片名称
     * @param path 存储路径
     */
    public static void download (String url, String filename, String path) {
        try {
            URL urlString = new URL(url); //构造URL
            URLConnection urlConnection = urlString.openConnection(); //打开连接
            urlConnection.setConnectTimeout(3000); // 设置请求超时为5s
            InputStream inputStream = urlConnection.getInputStream(); //输入流
            byte[] bs = new byte[1024]; //缓冲
            int len; //数据长度
            File file = new File(path); // 输出的文件流
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream outputStream = new FileOutputStream(file.getPath() + "\\" + filename);
            while ((len = inputStream.read(bs)) != -1) {
                outputStream.write(bs, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
