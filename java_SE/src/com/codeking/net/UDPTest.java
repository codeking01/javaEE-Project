package com.codeking.net;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author : codeking
 * @date : 2022/11/13 14:12
 */
public class UDPTest {
    @Test
    // 发送端
    public void senders() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        byte[] data="我是UDP发送端".getBytes(StandardCharsets.UTF_8);
        InetAddress inet=InetAddress.getLocalHost();
        // 封装数据包
        DatagramPacket packet=new DatagramPacket(data, 0,data.length,inet,8899);
        socket.send(packet);
        socket.close();
    }

    @Test
    // 接收端
    public void receive() throws IOException {
        DatagramSocket socket=new DatagramSocket(8899);
        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
