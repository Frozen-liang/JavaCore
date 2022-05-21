package day_07_泛型treeSet.课堂;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class treeSet {
    @Test
    public void 认识() {
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("222");
        treeSet.add("111");
        treeSet.add("333");
        treeSet.add("444");

        // 迭代器
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }


        // 增强
        for (String s : treeSet) {
            System.out.println(s);
        }
    }

    @Test
    public void 比较器() {
        // 类部比较器
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student(11, "梁杰栋"));
        students.add(new Student(11, "梁杰栋"));
        students.add(new Student(22, "罗志祥"));
        students.add(new Student(33, "周杰伦"));

        for (Student student : students) {
            System.out.println(student);
        }

        // 外部比较器
        TreeSet<Student1> students1 = new TreeSet<>(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o1.age - o2.age;
            }
        }
        );
        students1.add(new Student1(11, "梁杰栋"));
        students1.add(new Student1(11, "梁杰栋"));
        students1.add(new Student1(22, "罗志祥"));
        students1.add(new Student1(33, "周杰伦"));

        for (Student1 student1 : students1) {
            System.out.println(student1);
        }
    }

    public void test2() {
    }

    public void test3() {
    }
}

class Student1 {
    int age;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student1(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Student implements Comparable<Student> {
    int age;
    String name;

    @Override
    public int compareTo(Student o) {
        // 倒序
//        return o.age - this.age;
        // 升序
//        return this.age - o.age;
        // 改写不去重
        int result = this.age - o.age;
        return result == 0 ? 1 : result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}