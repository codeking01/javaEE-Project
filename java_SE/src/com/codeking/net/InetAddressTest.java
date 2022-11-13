package com.codeking.net;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : codeking
 * @date : 2022/11/12 17:14
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress net1 = InetAddress.getByName("127.0.0.1");
        System.out.println(net1);
        InetAddress net2 = InetAddress.getByName("www.baidu.com");
        System.out.println(net2);
        //InetAddress net3 = InetAddress.getByName("localhost");
        InetAddress net3 = InetAddress.getLocalHost();
        System.out.println(net3);

    }
}
