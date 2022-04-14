package day_10_IO流.课堂;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class 配置文件流 {

    // 读取配置文件
    @Test
    public void test1() throws IOException {
        // 创建对象
        Properties properties = new Properties();

        // 创建字节流
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/IdeaProjects/JavaCore/配置文件流.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        // 操作
//        properties.load(fileInputStream);
        properties.load(inputStreamReader);
        String s = properties.getProperty("梁杰栋");

        // 输出
        System.out.println(properties);
        System.out.println(s);

        // 关闭流
        fileInputStream.close();
    }
}
