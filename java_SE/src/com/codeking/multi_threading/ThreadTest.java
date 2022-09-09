package com.codeking.multi_threading;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author : codeking
 * @date : 2022/9/8 20:43
 */
public class ThreadTest extends Thread {
    private String url; //图片地址
    private String name; //保存图片的名字

    public ThreadTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 重写run方法
    @Override
    public void run() {
        // 下载图片
        WebDownloader downloader = new WebDownloader();
        downloader.downloadPicture(url, name);
        System.out.println("下载的文件名为：" + name);
    }

    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest("https://profile.csdnimg.cn/7/6/9/3_qyj19920704","图片1.jpg");
        ThreadTest thread2 = new ThreadTest("https://csdnimg.cn/release/blogv2/dist/pc/img/iconSideBeta.png","图片2.jpg");
        ThreadTest thread3 = new ThreadTest("https://cdn4.buysellads.net/uu/1/3386/1525189943-38523.png","图片3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WebDownloader {
    // 下载图片
    public void downloadPicture(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error downloading picture");
        }
    }
}
