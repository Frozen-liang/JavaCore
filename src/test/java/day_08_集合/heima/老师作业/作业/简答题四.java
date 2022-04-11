package day_08_集合.heima.老师作业.作业;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

class Student1_简答题三 {
    private String name;
    private int age;

    public Student1_简答题三(String name, int age) {
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
        return "Student_第一题{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}


class Student2_简答题四 implements Comparable<Student2_简答题四> {
    private String name;
    private int age;

    public Student2_简答题四(String name, int age) {
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
        return "Student_第一题{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student2_简答题四 o) {
        int age = this.age - o.age;
        int name = age == 0 ? this.name.compareTo(o.name) : age;
        return name;
    }
}

public class 简答题四 {
    @Test
    public void test1() {
        TreeMap<Student1_简答题三, String> map = new TreeMap<>();

        map.put(new Student1_简答题三("梁杰栋", 12), "湖南");
        map.put(new Student1_简答题三("罗志祥", 12), "台湾");

        // 直接执行会发生错误 因为没有实现比较器 一个外部compare 一个内部compareTo
        map.forEach((stu, address) -> System.out.println(stu + "--" + address));
    }

    @Test
    public void test2() {
        TreeMap<Student1_简答题三, String> map = new TreeMap<>(new Comparator<Student1_简答题三>() {
            @Override
            public int compare(Student1_简答题三 o1, Student1_简答题三 o2) {
                return 0;
            }
        });

        map.put(new Student1_简答题三("梁杰栋", 12), "湖南");
        map.put(new Student1_简答题三("罗志祥", 12), "台湾");

        // 显示比较器 会自动去重
        map.forEach((stu, address) -> System.out.println(stu + "--" + address));
    }

    @Test
    public void test3() {
        // 实现外部比较器
        // 对学生进行先按照年龄从小到大排序，如果年龄相同则按照姓名从小到大进行排序
        TreeMap<Student2_简答题四, String> map = new TreeMap<>();

        map.put(new Student2_简答题四("梁杰栋", 13), "湖南");
        map.put(new Student2_简答题四("罗志祥", 12), "台湾");
        map.put(new Student2_简答题四("周杰伦", 14), "台湾");
        map.put(new Student2_简答题四("梁杰栋", 12), "湖南");

        // 杰比志在前输出
        map.forEach((stu, address) -> System.out.println(stu + "--" + address));
    }
}
