package day_12_网络编程.课堂;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class 通信 {

    @Test
    public void TCP_Client() throws IOException {
        Socket socket = new Socket("192.168.30.55",10000);

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.write("梁杰栋是大帅比");

        printWriter.close();
        socket.close();
    }

    @Test
    public void TCP_Service() throws IOException {
        // 创建服务器客户端对象
        ServerSocket serverSocket = new ServerSocket(10000);
//        监听客户端数据
        Socket socket = serverSocket.accept();

        InetAddress inetAddress = serverSocket.getInetAddress();


//        printWriter.close();
        socket.close();
    }
}
