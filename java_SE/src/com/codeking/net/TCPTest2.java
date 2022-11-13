package com.codeking.net;

import org.junit.Test;
import sun.java2d.opengl.WGLGraphicsConfig;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * * 实现TCP的网络编程
 * * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author : codeking
 * @date : 2022/11/13 12:20
 */
public class TCPTest2 {

    @Test
    public void Client() throws IOException {
        //1.创建Socket对象，指明服务器端的ip和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
        //2.获取一个输出流，用于输出数据
        OutputStream os = socket.getOutputStream();
        System.out.println("我要开始发送照片了...");
        // 发送图片
        FileInputStream fis=new FileInputStream(new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE\\src\\com\\codeking\\net\\head.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        System.out.println("发送成功！");
        // 关闭数据输出，不然会一直转圈圈
        socket.shutdownOutput();
        //5.接收来自服务器端的数据，并显示到控制台上
        InputStream is=socket.getInputStream();
        // ByteArrayOutputStream 是可扩展的数组
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[50];
        int len1;
        while ((len1=is.read(buffer))!=-1){
            baos.write(buffer,0,len1);
        }
        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();
    }


    @Test
    public void Server() throws IOException {
        //1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(8899);
        //2.调用accept()表示接收来自于客户端的socket
        Socket socket = serverSocket.accept();
        //3.获取输出流
        InputStream is = socket.getInputStream();
        //4.写出 输出流中的数据
        FileOutputStream fos = new FileOutputStream(new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE\\src\\com\\codeking\\net\\head2.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len =is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        System.out.println("图片传输完成");
        //6.服务器端给予客户端反馈
        OutputStream os=socket.getOutputStream();
        os.write("图片收到了，长的很帅！".getBytes());
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
        os.close();
    }

}
