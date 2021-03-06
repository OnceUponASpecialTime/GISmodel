package cn.swjtu.gis.main;

/**
 * Created by Foutas on 2017/6/7.
 */
public class CtorThread extends Thread {
    TaskServer taskServer = null;
    TriggerEvent triggerEvent = null;

    public CtorThread (TaskServer taskServer, TriggerEvent triggerEvent) {
        this.taskServer = taskServer;
        this.triggerEvent = triggerEvent;
    }

    public void run() {
        while (true) {
            triggerEvent.checkEvent();

            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
