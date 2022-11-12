package com.codeking.io;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 1、写入文件
 * <p>
 * 创建流对象，建立数据存放文件
 * <p>
 * FileWriterfw= new FileWriter(new File(“Test.txt”));
 * 1
 * 调用流对象的写入方法，将数据写入流
 * <p>
 * fw.write(“atguigu-songhongkang”);
 * 1
 * 关闭流资源，并将流中的数据清空到文件中。
 * <p>
 * fw.close();
 * ————————————————
 *
 * @author : codeking
 * @date : 2022/11/11 19:48
 */
public class FileWriterTest {
    /**
     * * 从内存中写出数据到硬盘的文件里。
     * *
     * * 说明：
     * * 1.输出操作，对应的File可以不存在的。并不会报异常
     * * 2.
     * *   File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     * *   File对应的硬盘中的文件如果存在：
     * *       如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
     * *       如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     * ————————————————
     */
    @Test
    public void test1() {
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            fw = new FileWriter(file, true);
            fw.write("hello");
            System.out.println("添加成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
