package com.codeking.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 *  * public boolean isDirectory()：判断是否是文件目录
 *      * public boolean isFile() ：判断是否是文件
 *      * public boolean exists() ：判断是否存在
 *      * public boolean canRead() ：判断是否可读
 *      * public boolean canWrite() ：判断是否可写
 *      * public boolean isHidden() ：判断是否隐藏
 *  * 创建硬盘中对应的文件或文件目录
 *      * public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 *      * public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
 *      * public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
 *      *
 *      *     删除磁盘中的文件或文件目录
 *      * public boolean delete()：删除文件或者文件夹
 *      *     删除注意事项：Java中的删除不走回收站。
 *
 * @author : codeking
 * @date : 2022/11/10 20:37
 */
public class FileTest {
    @Test
    public void testFile() throws IOException {
        /*File file = new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE\\src\\com\\codeking\\io\\test.txt");
        System.out.println(new Date(file.lastModified()));
        File file1 = new File("hello.txt");
        boolean renameTo = file.renameTo(file1);
        System.out.println(renameTo);*/

        File file1 = new File("hello.jpg");
        if (!file1.exists()){
            //文件的创建
            file1.createNewFile();
            //file1.delete();
            System.out.println("创建成功");
            //System.out.println("删除成功");
        }
    }

    @Test
    public void testFindJPGFile(){
        File srcFiles=new File("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE");
        String[] filename=srcFiles.list();
        for (String s : filename) {
            if (s.endsWith(".jpg")){
                System.out.println(s);
            }
        }

    }
}
