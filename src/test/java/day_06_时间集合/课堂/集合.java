package day_06_时间集合.课堂;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class 集合 {
    @Test
    public void ArrayList(){
        ArrayList<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");

        // 查询集合中的个数
        System.out.println(list.size());

        // 移除指定元素元素
        System.out.println(list.remove("bb"));
        System.out.println(list);

        // 移除集合只中指定的多个元素
        System.out.println(list.removeIf(s -> s.equals("bb")));
        System.out.println(list);

        // 指定下标元素删除
        System.out.println(list.remove(2));
        System.out.println(list);

        // 找到指定的元素
        System.out.println(list.contains("aa"));
        System.out.println(list.contains("bb"));

        // 指定得到下标元素
        System.out.println(list.get(0));

        // 清空集合
        list.clear();
        System.out.println(list);
    }

    @Test
    public void 迭代器(){
        Collection<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("bb");
        list.add("bb");
        list.add("cc");

        // 创建迭代器对象
        Iterator<String> iterator = list.iterator();

        // 遍历迭代器
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void 遍历对象(){
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("ljd", 12));
        list.add(new Student("wyf", 13));
        list.add(new Student("lzx", 14));
        list.add(new Student("zjl", 15));

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next.name+" "+next.age);
        }

        for (Student student : list) {
            System.out.println(student.name+" "+student.age);
        }
    }

}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}