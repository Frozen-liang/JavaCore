package day_06_时间集合.老师作业.作业;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 简答题 {
    @Test
    public void 三() {
        ArrayList<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void si() {
        // 通过多态的方式创建一个List集合对象
        List<String> list = new ArrayList<String>();

// 添加元素
        list.add("itheima");
        list.add("itcast");
        list.add("传智播客");
        list.add("黑马程序员");

// 遍历集合
        for (int x = 0; x < list.size(); x++) {
            System.out.println(list.remove(x));
            x--;
        }
        System.out.println(list.size());
    }

    @Test
    public void wu() {
        List<String> list = new ArrayList<String>();

// 添加元素
        list.add("itheima");
        list.add("itcast");
        list.add("传智播客");
        list.add("itheima");

// 获取迭代器对象，通过迭代器对象对集合进行遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // 获取元素
            String next = iterator.next();
            // 判断元素
            if (next.equals("itheima"))
                // 删除指定元素
                iterator.remove();
        }

// 遍历集合
        list.forEach(s -> System.out.println(s));
    }
}
