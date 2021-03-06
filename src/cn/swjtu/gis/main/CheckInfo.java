package cn.swjtu.gis.main;

import cn.swjtu.gis.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Foutas on 2017/6/5.
 */
public class CheckInfo {

    private static final String SQL1 = "select * from gis where name =";//------表名视具体数据表而定
    private static final String SQL2 = "select state from gis";
    private DBUtil dbUtil;
    static DBUtil db1 = null;
    static DBUtil db2 = null;
    static ResultSet rs = null;

    /**
     *
     * @return 获取数据库中设备名对应的状态信息
     * @throws Exception
     */
    public Map<String, String> getInfo() throws Exception{
        Map<String, String> map = new HashMap<>();
        String attribute = null;
        String state = null;
        db1 = new DBUtil(SQL1+ getName());
        try{
            rs = db1.pst.executeQuery();
            while (rs.next()) {
                attribute = rs.getString(2);//-----------具体视情况而定
                state = rs.getString(3);//---------------此处根据表中状态信息在第几列而定
            }
            map.put("属性", attribute);
            map.put("状态", state);
            rs.close();
            db1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


    public Map<String, ArrayList<String>> getStateInfo(){
        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> as = new ArrayList<>();
        String state = null;
        db2 = new DBUtil(SQL2);
        try {
            rs = db2.pst.executeQuery();
            while (rs.next()) {
                as.add(rs.getString(0));
            }
            map.put("状态", as);
            rs.close();
            db2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    //在事件触发时获取该设备的在表中对应的名称
    private String getName() {
        String s = null;

        return s;
    }
}
