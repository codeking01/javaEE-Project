package com.codeking.io;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * @author : codeking
 * @date : 2022/11/11 12:49
 */
public class ListFilesTest {
    public static void main(String[] args) {
        File file = new File("C:\\ALL_Softwares");
        printSubFile(file);
    }

    public static void printSubFile(@NotNull File file) {
        // 打印目录子文件
        File[] subFiles =file.listFiles();
        for (File subFile : subFiles) {
            if (subFile.isDirectory()) {
                printSubFile(subFile);
            }else {
                System.out.println("ss"+file.getAbsolutePath());
            }
        }
    }
}
