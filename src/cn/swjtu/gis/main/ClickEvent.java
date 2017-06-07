package cn.swjtu.gis.main;

/**
 * Created by Foutas on 2017/6/7.
 */
public class ClickEvent extends Thread {

    TaskServer taskServer = null;
    CheckInfo checkInfo = null;

    public ClickEvent (TaskServer taskServer, CheckInfo checkInfo) {
        this.checkInfo = checkInfo;
        this.taskServer = taskServer;
    }

    public void run() {

    }
}
