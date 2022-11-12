package com.codeking.assemblages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : codeking
 * @date : 2022/11/9 19:01
 */
public class PropertiesTest {
    public static void main(String[] args) {
        //Properties:常用来处理配置文件。key和value都是String类型
        // FileInputStream（需要写较为完整的路径）和 BufferedInputStream(可以读取当前包下的文件内容) 都可以读取文件操作
        BufferedInputStream fis = null;
        try {
            Properties pros = new Properties();
            //fis = new FileInputStream("java_SE\\src\\com\\codeking\\assemblages\\jdbc.properties");
            fis = (BufferedInputStream) PropertiesTest.class.getResourceAsStream("jdbc.properties");
            //加载流对应文件
            pros.load(fis);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
