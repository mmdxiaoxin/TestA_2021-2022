package work4;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerThread server = new ServerThread();
        server.start();
    }
}

class ServerThread extends Thread {
    @Override
    public void run() {
        super.run();
        ServerSocket serverSocket = null;
        Socket accept = null;
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("服务端运行...");
            accept = serverSocket.accept();
            System.out.println("一个客户端已成功连接！");
            dos = new DataOutputStream(accept.getOutputStream());
            ois = new ObjectInputStream(accept.getInputStream());
            while (true) {
                //接收数据
                System.out.println("接收数据！");
                //读出传入的对象
                Rectangle rect = (Rectangle) ois.readObject();
                //发送数据
                dos.writeDouble(rect.getArea());
                dos.flush();
                System.out.println("发送数据！");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (ois != null) {
                    ois.close();
                }
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("服务端关闭...");
        }
    }
}