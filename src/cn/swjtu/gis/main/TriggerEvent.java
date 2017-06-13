package cn.swjtu.gis.main;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Foutas on 2017/6/6.
 */
public class TriggerEvent extends Thread {

    TaskServer ts = null;
    CheckInfo checkInfo = null;

    public TriggerEvent (TaskServer ts, CheckInfo ci) {
        this.ts = ts;
        this.checkInfo = ci;
    }


    public void checkEvent() {
        Map<String, ArrayList<String>> map = checkInfo.getStateInfo();
        ArrayList<String> as = map.get(0);
        for (int i = 0; i < as.size(); i++) {
            if (as.get(i) == "error") {
                try {
                    answerEvent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     *
     * 需要调用JavaScript中的方法使第n个设备报警
     *
     */
    private void answerEvent() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        String jsFileName = "D:\\Ccode\\alertsound.html";
        FileReader reader = null;
        try {
            reader = new FileReader(jsFileName);
            engine.eval(reader);
            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable)engine;
            }
        } catch (Exception e) {
            e.printStackTrace();
            reader.close();
        }
    }
}
