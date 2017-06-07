package cn.swjtu.gis.main;

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


    public void answerEvent() {

    }
}
