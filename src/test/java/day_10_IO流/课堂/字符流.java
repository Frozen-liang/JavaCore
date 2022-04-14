package day_10_IO流.课堂;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.TreeMap;

public class 字符流 {

    // 字符操作流程
    @Test
    public void test1() throws IOException {
        // 创建对象
        FileWriter fileWriter = new FileWriter("/Users/apple/练习文件/IO/字符文件/a.txt");
        FileReader fileReader = new FileReader("/Users/apple/练习文件/IO/字符文件/a.txt");

        fileWriter.write("我是字符流");
//        fileWriter.flush();
//        fileWriter.close();

        // 创建高效流对象
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 问题 bufferedWriter无法写入数据
//        bufferedWriter.write("我是字符流");

        // 操作
        String len;
        while ((len = bufferedReader.readLine()) != null) {
            // 操作同一个文件 写入数据的时候 会先删除旧数据 然后写入新数据 但是读出的是旧文件为null
            // 所以写入是就要 刷新或者关闭 保存 才会读取新文件
            System.out.println(len);
        }

        // 刷新或者关闭流
        fileReader.close();
        fileWriter.close();
    }

    // 文本 转化为 map 排序
    @Test
    public void test2() throws IOException {
        // 创建读文本对象
        FileReader fileReader = new FileReader("/Users/apple/练习文件/IO/字符文件/出师表.txt");
        // 创建高效流
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String s;
        // 创建map集合存储
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 读出一行存入数组
        while ((s = bufferedReader.readLine()) != null) {
            // 创建数组存储 多行数据
            // 把数组分为两块

//            String[] strings = bufferedReader.readLine().split("\\.");  如果用这个 会隔行输出
            // 用 . 分割为两块
            String[] strings = s.split("\\.");
            // 把两块 作为key 和 value
            String key = strings[0];
            String value = strings[1];
            treeMap.put(Integer.parseInt(key), value);
        }
        treeMap.forEach((k, v) -> System.out.println(k + "." + v));
        // 关闭流
        fileReader.close();

        FileWriter fileWriter = new FileWriter("/Users/apple/练习文件/IO/字符文件/出师表_副本.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        treeMap.forEach((k, v) -> {
            //拿到 key 和 value 并且写入
            try {
                bufferedWriter.write(k + "." + v);
                // 遇见换行符自动识别系统换行
                bufferedWriter.newLine();
//                bufferedWriter.close(); 不能使用关闭 要一直循环写完 最后关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bufferedWriter.close();
    }

    // 字符转换流 写
    @Test
    public void test4() throws IOException {
        // 创建字节输出对象
        FileOutputStream fileOutputStream =
                new FileOutputStream("/Users/apple/练习文件/IO/字符文件/字符转换流.txt",true);

        // 创建字节转换字符对象
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");

        // 操作 输出到文本
        outputStreamWriter.write("我爱你");

        // 关闭流 自动关闭字节流
        outputStreamWriter.close();
    }

    // 字符转换流 读
    @Test
    public void test3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/apple/练习文件/IO/字符文件/字符转换流.txt");

//        FileWriter fileWriter = new FileWriter("/Users/apple/练习文件/IO/字符文件/字符转换流.txt");
//        fileWriter.write("我爱你");
//        fileWriter.close();

        // 直接输出 无法转换 乱码
//        int len;
//        while ((len = fileInputStream.read()) != -1){
//            System.out.print((char) len);
//        }

        // 创建转换流对象
        // 将字节流转化为字符流
        InputStreamReader isr = new InputStreamReader(fileInputStream, "UTF-8");
        // 创建高效流
        BufferedReader bufferedReader = new BufferedReader(isr);
        System.out.println(bufferedReader.readLine());

        // 只关闭转换流 自动关闭字节流
        isr.close();
    }
}
