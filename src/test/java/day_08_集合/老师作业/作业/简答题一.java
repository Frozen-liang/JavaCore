package day_08_集合.老师作业.作业;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

class Student_第一题 {
    private String name;
    private int age;

    public Student_第一题(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student_第一题 that = (Student_第一题) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class 简答题一 {
    @Test
    public void test() {
        HashSet<Student_第一题> set = new HashSet<>();

        set.add(new Student_第一题("梁杰栋", 12));
        set.add(new Student_第一题("罗志祥", 12));
        set.add(new Student_第一题("周杰伦", 12));
        set.add(new Student_第一题("梁杰栋", 12));
        // 输出会把所有的内容输出 因为创建的对象 地址是不同的
        set.forEach(System.out::println);
        // 想要去重的话 需要重写equals
    }
}
