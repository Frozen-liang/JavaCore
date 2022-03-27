package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @date 2022/3/27 - 20:40
 */
class Collection_Book {
    private String name;
    private String author;

    public Collection_Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Collection_Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

@SuppressWarnings("all")
public class Collection_test {
    @Test
    public void test_简单介绍() {
        // 单列集合
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        // 双列集合
        HashMap hashMap = new HashMap();
        hashMap.put("1", "liang");
    }

    @Test
    public void test_Collection方法() {

// Iterator 迭代器对象 对集合元素的遍历 并不存放数据 itit
        Collection col = new ArrayList();
        col.add(new Collection_Book("hlm", "ljd"));
        col.add(new Collection_Book("sgyy", "ljd"));

        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {
            // 编译对象为obj 运行对象为Collection_Book
            Object obj = iterator.next();
            System.out.println(obj);
        }

        System.out.println();

        // 第二次迭代 重置 iterator.hasNext()
        Iterator iterator1 = col.iterator();
        while (iterator1.hasNext()) {
            Object obj1 = iterator1.next();
            System.out.println(obj1);
        }
        System.out.println();

//  增强for 简单的迭代器 快捷键 I
        // 间接实现了Iterator iterator1 = col.iterator();
        // 向上转型 Object object = Collection_Book
        for (Object book : col) {
            System.out.println(book);
        }
    }

    @Test
    public void test_List方法() {
// ArrayList  增删改查插 替换
        List vector = new Vector();
        List linkedList = new LinkedList();
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list);

        // 查 索引0开始
        System.out.println(list.get(0));
    }

    @Test
    public void test_ArrayList_底层源码() {
        // 无参构造器
        List list = new ArrayList();

    }
}
