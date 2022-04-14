package day_10_IO流.课堂;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

// 实现序列化接口
// 序列化接口是一个标志性接口 把对象转化为二进制
class 对象流_student implements Serializable {

    // 防止类改变 自动生成serialVersionUID报错 自定义大小 作为一个类的初始标识
    private static final long serialVersionUID = 1L;

    private String name;
    // transient表明无法被序列化
    private transient int age;

    public 对象流_student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "对象流_student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class 对象流 {

    // 序列化
    @Test
    public void ObjectOutputStream() throws IOException {
        // 创建学生对象
        对象流_student 对象流_student1 = new 对象流_student("梁杰栋", 18);
        对象流_student 对象流_student2 = new 对象流_student("罗志祥", 18);
        对象流_student 对象流_student3 = new 对象流_student("周杰伦", 18);

        // 创建集合封装对象
        ArrayList<对象流_student> studentArrayList = new ArrayList<>();
        studentArrayList.add(对象流_student1);
        studentArrayList.add(对象流_student2);
        studentArrayList.add(对象流_student3);

        // 创建文件
        File file = new File("/Users/apple/练习文件/IO/字符文件/对象流_student.txt");
        file.createNewFile();

        // 创建对象流
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("/Users/apple/练习文件/IO/字符文件/对象流_student.txt"));

        // 循环写入对象
        for (对象流_student student : studentArrayList) {
            objectOutputStream.writeObject(student);
        }

        // 关闭流
        objectOutputStream.close();
    }

    // 反序列化
    @Test
    public void ObjectInputStream() throws IOException, ClassNotFoundException {

        // 创建反序列化ObjectInputStream对象
        // 操作 循环序列化
        // 强制转换object 为 已知道的类
        // 文件读完不会返回任何值 会抛出一个异常
        // 关闭流
        while (true) {
            try (ObjectInputStream objectInputStream =
                         new ObjectInputStream(new FileInputStream("/Users/apple/练习文件/IO/字符文件/对象流_student.txt"));
            ) {
                // 问题如何读取下一个对象
                objectInputStream.readObject();

                // 输出
//                System.out.println(student);
            } catch (EOFException e) {
                System.out.println("文件读取完毕");
                break;
            }
        }
    }
}
