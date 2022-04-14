package day_10_IO流.课堂;

import org.junit.Test;

import java.io.*;

public class IO流基本操作 {

    // 写入基本使用
    @Test
    public void outPutStream_1() throws IOException {
        // 创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/apple/练习文件/IO/io1.txt");

        fileOutputStream.write('a' + '\n');

        // 创建字节数组
        byte arr[] = new byte[]{97, 98, 99, 13};
        fileOutputStream.write(arr);

        // 关闭对文件的占用权
        fileOutputStream.close();
    }

    // 输出单个
    // 输出多个
    @Test
    public void inputStream1() throws IOException {
        // 创建对象
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/练习文件/IO/io1.txt");

        // 读取操作
        int read = fileInputStream.read();
        System.out.println(read);
        System.out.println((char) read);

        // 遍历读取 读取到文件末尾为-1
        System.out.println("输出多个");
        int len;
        while ((len = fileInputStream.read()) != -1) {
            System.out.println(len);
        }

        fileInputStream.close();
    }

    // 拷贝复制文件
    @Test
    public void test2() throws IOException {
        // 创建读写对象
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/练习文件/IO/io1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/apple/练习文件/IO/io1_副本.txt");

        // 边读边写
        int len;
        while ((len = fileInputStream.read()) != -1) {
            System.out.println(len);
            fileOutputStream.write(len);
        }

        // 关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }

    // 用字节数组作为缓存 拷贝复制文件
    @Test
    public void test3() throws IOException {
        // 创建读写对象
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/练习文件/IO/io1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/apple/练习文件/IO/io1_副本.txt");

        // 创建字节数组 边读边写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        // 关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }

    // 用缓冲流数组作为缓存 内存中一个字节传输
    @Test
    public void test4() throws IOException {
        // 创建缓冲数组读写对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/apple/练习文件/IO/io1.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/apple/练习文件/IO/io1_副本Buffered.txt"));

        // 操作
        int len;
        while ((len = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(len);
        }

        // 关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    // 用缓冲流数组 和 缓冲数组结合 内存中 缓冲数组传输
    @Test
    public void test5() throws IOException {
        // 创建缓冲数组读写对象
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream("/Users/apple/练习文件/IO/io1.txt"));
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream("/Users/apple/练习文件/IO/io1_副本Buffered_Array.txt"));

        // 创建缓冲数组
        byte[] bytes = new byte[5];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        // 关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    @Test
    public void test6() throws IOException {
        // 创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/apple/练习文件/IO/字节流文件/a.txt");
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/练习文件/IO/字节流文件/a.txt");

        // 操作
        fileOutputStream.write(123);

        // 读取
        int len;
        while ((len = fileInputStream.read()) != -1){
            System.out.println(len);
        }

        //
        fileInputStream.close();
        fileOutputStream.close();
    }
}
