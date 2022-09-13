package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/9 9:43
 *
 * 实现Runnable接口实现多线程
 */
public class ThreadRunnableTest implements Runnable {
    private String url; //图片地址
    private String name; //保存图片的名字

    public ThreadRunnableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        // 下载图片
        WebDownloader downloader = new WebDownloader();
        downloader.downloadPicture(url, name);
        System.out.println("下载的文件名为：" + name);
    }

    public static void main(String[] args) {
        ThreadRunnableTest tread1 = new ThreadRunnableTest("https://profile.csdnimg.cn/7/6/9/3_qyj19920704", "图片1.jpg");
        ThreadRunnableTest tread2 = new ThreadRunnableTest("https://csdnimg.cn/release/blogv2/dist/pc/img/iconSideBeta.png", "图片2.jpg");
        ThreadRunnableTest tread3 = new ThreadRunnableTest("https://cdn4.buysellads.net/uu/1/3386/1525189943-38523.png", "图片3.jpg");
        new Thread(tread1).start();
        new Thread(tread2).start();
        new Thread(tread3).start();
    }
}


// 实现Runnable接口


