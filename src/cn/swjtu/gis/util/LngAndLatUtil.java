package cn.swjtu.gis.util;


import net.sf.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Foutas on 2017/6/25.
 */
public class LngAndLatUtil {

    private static final String OUTPUT_PATH = "D:\\Ccode\\Offline_api\\baidumapv2.0.3\\location.txt";

    public static Map<String, Double> getLngAndLat(String address) {
        Map<String, Double> map = new HashMap<>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak=CnGXL88ccYnfphFcic4xkHBexfK0g6ok";
        String json = loadJSON(url);
        JSONObject jsonObject = JSONObject.fromObject(json);
        if (jsonObject.get("status").toString().equals("0")) {
            double lng = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
        } else {
            System.out.println("未匹配到相应经纬度");
        }
        return map;
    }

    private static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL path = new URL(url);
            URLConnection urlConnection = path.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine())!=null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static void main(String[] args) {
        Map<String, Double> map = LngAndLatUtil.getLngAndLat("天安门");
        StringBuffer str = new StringBuffer();
        str.append(map.get("lng")+","+map.get("lat") + "\n");
        try (PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_PATH, true))) {
            out.print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
