package cn.swjtu.gis.main;

import java.net.Socket;

/**
 * Created by Foutas on 2017/6/7.
 */
public class TaskRequestHandlerThread extends Thread{

    protected Socket socket;

    TaskServer taskServer = null;
    TriggerEvent triggerEvent = null;

    public TaskRequestHandlerThread(Socket socket, TaskServer taskServer, TriggerEvent triggerEvent) {
        this.socket = socket;
        this.taskServer = taskServer;
        this.triggerEvent = triggerEvent;
    }

    public void run() {

    }
}
