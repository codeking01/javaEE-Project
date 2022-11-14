package com.codeking.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author : codeking
 * @date : 2022/11/14 14:38
 */
public class ClassLoaderTest {
    /**
     * Properties：用来读取配置文件。
     *
     * @throws Exception
     */
    @Test
    public void testClassLoader() throws Exception {
        Properties props = new Properties();
        ClassLoader cls=ClassLoaderTest.class.getClassLoader();
        // getResourceAsStream 只能接受相对路径，这个路径相较于module的
        //InputStream is= cls.getResourceAsStream("jdbc.properties");
        FileInputStream fis = new FileInputStream("C:\\ALL_Softwares\\Develop_Tools\\Java_project\\JavaSE\\java_SE\\src\\com\\codeking\\reflection\\jdbc.properties");
        props.load(fis);
        String name=props.getProperty("name");
        String password=props.getProperty("password");
        System.out.println("name="+ name+","+"password="+password);

    }
}
