package com.codeking.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <>流的分类
 * 按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
 * 按数据流的流向不同分为：输入流，输出流
 * 按流的角色的不同分为：节点流，处理流
 * <p>
 * FileReader读入数据的基本操作
 * 1、读取文件【四个步骤】
 * <p>
 * 建立一个流对象，将已存在的一个文件加载进流。
 * <p>
 * FileReaderfr= new FileReader(new File(“Test.txt”));
 * 1
 * 创建一个临时存放数据的数组。
 * <p>
 * char[] ch= new char[1024];
 * 1
 * 调用流对象的读取方法将流中的数据读入到数组中。
 * <p>
 * fr.read(ch);
 * 1
 * 关闭资源。
 * <p>
 * fr.close();
 *
 * @author : codeking
 * @date : 2022/11/11 16:30
 */
public class FileReaderTest {
    @Test
    public void testReader() {
        FileReader fileContent = null;
        try {
            File file1 = new File("hello.txt");
            fileContent = new FileReader(file1);
            //char[] ch = new char[1024];
            int data = fileContent.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fileContent.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileContent != null) {
                    fileContent.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void testFileReade() throws IOException {
        FileReader fileContent = null;
        try {
            File file1 = new File("hello.txt");
            fileContent = new FileReader(file1);
            // 可以用数组去接受
            char[] cbuf = new char[5];
            int len;
            fileContent.read(cbuf);
            while ((len = fileContent.read(cbuf)) != -1) {
                // 方式一
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }
                // 方式二
                String str=new String(cbuf,0,len);
                System.out.println("方式二："+str);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileContent != null) {
                    fileContent.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
