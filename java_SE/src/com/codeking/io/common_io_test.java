package com.codeking.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author : codeking
 * @date : 2022/11/12 16:41
 */
public class common_io_test {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE\\hello.txt");
        File file2 = new File("hello2.txt");
        FileUtils.copyFile(file1, file2);
    }
    @Test
    public  void test1() throws IOException {
        try {
            File file2 = new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\hello2.txt");
            file2.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
