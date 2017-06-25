package cn.swjtu.gis.main;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * Created by Foutas on 2017/6/19.
 */
public class CallJS {

    private static final String jsFileName = "D:\\Ccode\\Offline_api\\baidumapv2.0.3\\background.js";

    public void getJS() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        try {
            FileReader reader = new FileReader(jsFileName);
            engine.eval(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
