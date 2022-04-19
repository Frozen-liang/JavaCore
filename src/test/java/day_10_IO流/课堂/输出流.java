package day_10_IO流.课堂;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class 输出流 {

    // PrintWriter
    @Test
    public void test1() throws FileNotFoundException {
        // 创建输出流对象
        PrintWriter printWriter1 = new PrintWriter(new FileOutputStream("/Users/apple/练习文件/IO/输出流/测试.txt"),true);
        // 参数追加
        PrintWriter printWriter2 = new PrintWriter(new FileOutputStream("/Users/apple/练习文件/IO/输出流/测试.txt",true),true);

        // 操作 构造函数两个参数 自动刷新
        printWriter1.println(123);
        printWriter2.println("abc,梁杰栋");

        // 无需关闭
    }

    // PrintWriter 改写输出
    @Test
    public void test2 () throws IOException {
        // 构建对象
        PrintWriter printWriter1 = new PrintWriter(new FileOutputStream("/Users/apple/练习文件/IO/输出流/测试—改写输出位置.txt"),true);

        // 改写输出
    }
}
