package work4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

//非原题所需，用来参考使用
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream oos = null;
        DataInputStream dis = null;
        try {
            socket = new Socket("localhost", 9999);
            System.out.println("客户端端运行...");
            //发送
            oos = new ObjectOutputStream(socket.getOutputStream());
            Rectangle rect = new Rectangle(10.0, 10.0);
            oos.writeObject(rect);
            System.out.println("客户端端发送...");
            //接收
            dis = new DataInputStream(socket.getInputStream());
            double area = dis.readDouble();
            System.out.println("客户端端接收...");
            System.out.println(area);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("客户端关闭...");
        }
    }
}
