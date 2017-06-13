package cn.swjtu.gis.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Foutas on 2017/6/7.
 */
public class TaskServer {
    int port = 0;
    CheckInfo checkInfo = null;
    ServerSocket serverSocket = null;
    TriggerEvent triggerEvent = null;

    public static LinkedList toDoList = new LinkedList();

    public TaskServer(int port) {
        this.port = port;
    }

    public int run() {
        //服务器正在监听端口
        CtorThread ct = new CtorThread(this, triggerEvent);

            try {
                ct.start();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }

            try {
                //创建监听socket
                serverSocket = new ServerSocket(port);
            } catch (java.net.BindException e) {
                e.printStackTrace();
                return -2;
            } catch (IOException e) {
                e.printStackTrace();
                return -2;
            }


        Socket clientSocket = null;
        while(true) {
            try {
                //接收连接请求
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                return -3;
            }

            try {
                //启动处理线程
                TaskRequestHandlerThread taskRequestHandlerThread = new TaskRequestHandlerThread(clientSocket, this, triggerEvent);
                taskRequestHandlerThread.start();
            } catch (Exception e) {
                e.printStackTrace();
                return -4;
            }
        }

    }
}
