package day_10_IO流.作业;

import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;

public class 复制 {

    @Test
    public void test() {
        FileCopy fileCopy = new FileCopy("/Users/apple/练习文件/IO/io1.txt","/Users/apple/练习文件/IO/io1-副本.txt");
        FileCopy fileCopy2 = new FileCopy("/Users/apple/练习文件/IO/io2.txt","/Users/apple/练习文件/IO/io2-副本.txt");
        FileCopy fileCopy3 = new FileCopy("/Users/apple/练习文件/IO/io3.txt","/Users/apple/练习文件/IO/io3-副本.txt");

        new Thread(fileCopy).start();
        new Thread(fileCopy2).start();
        new Thread(fileCopy3).start();

    }

    class FileCopy implements Runnable {
        //表示源文件
        public File oldFile;
        //表示目标文件
        public File newFile;

        public FileCopy(String oldFile, String newFile) {
            this.oldFile = new File(oldFile);
            this.newFile = new File(newFile);
        }

        @Override
        public void run() {

            //创建文件输入输出流
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;

            try {
                fileInputStream = new FileInputStream(oldFile);
                fileOutputStream = new FileOutputStream(newFile);

                //声明一个字节数组，将每次读取的数据放入  字节数组的长度自己设定
                //如果要读取的文件中的数据比较少的话，建议设的值小一些，这样可以看清楚复制进度
                byte[] bytes = new byte[512];
                //返回每次读取的长度
                int length;
                //得到源文件的字节长度
                long len = oldFile.length();

                double temp = 0;

                //数据格式化
                DecimalFormat fd = new DecimalFormat("##%");
                //从数组中读取数据并返回长度
                while ((length = fileInputStream.read(bytes)) != -1) {
                    //将数组中的数据放入到目标路径中去，数据长度是length
                    fileOutputStream.write(bytes, 0, length);
                    //把每次读取到的数据累加
                    temp = temp + length;
                    //将读取到的长度/文件总长度
                    double d = temp / len;
                    System.out.println(oldFile.getName() + "文件复制到" + newFile.getName() + "已经复制了" + fd.format(d));
                }
                System.out.println(oldFile.getName() + "文件复制完毕");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
