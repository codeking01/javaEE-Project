package com.codeking.io;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * *
 * * 结论：
 * *    1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * *    2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 * ————————————————
 *
 * @author : codeking
 * @date : 2022/11/11 20:07
 */
public class FileOutputStreamTest {
    FileInputStream fis = null;
    FileOutputStream fos = null;

    @Test
    public void test1() throws IOException {
        //1.造文件
        File srcFile = new File("hello.txt");
        File destFile = new File("hello1.txt");
        //2.造流
        fis = new FileInputStream(srcFile);
        fos = new FileOutputStream(destFile);

        //3.复制的过程
        byte[] buffer = new byte[5];
        int len;
        //4.读数据
        while ((len = fis.read(buffer)) != -1) {
            // 使用中文可能乱码 因为中文是gbk比utf-8更加长
            //String str=new String(buffer,0,len);
            //System.out.println(str);
            fos.write(buffer, 0, len);
        }
        System.out.println("复制成功");
        fis.close();
        fos.close();
    }
}
