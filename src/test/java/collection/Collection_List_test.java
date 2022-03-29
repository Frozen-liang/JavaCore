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
public class Collection_List_test {
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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        System.out.println(list);

        // 查 索引0开始
        System.out.println(list.get(0));
    }

    @Test
    public void test_ArrayList_底层源码() {
        // 无参构造器
        List list1 = new ArrayList();
        // 有参构造器
        List list2 = new ArrayList(5);
    }

    @Test
    public void test_Vector_底层源码() {
        // 无参构造器
        List list1 = new Vector();
        list1.add(1);
        /*
            public synchronized void addElement(E obj)
            {
                modCount++;
                add(obj, elementData, elementCount);
            }
        */
        // 有参构造器
        List list2 = new Vector(5);
    }

    @Test
    public void test_LinkedLIst_底层源码() {
// 维护的是一个双向链表
        // 无参构造
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        // 默认删除第一个元素
        linkedList1.remove();
        linkedList1.set(1, 999);
        System.out.println(linkedList1.get(1));

//        for (Object o : linkedList1) {
//            System.out.println(o);
//        }

        // 有参构造 参数是集合
        LinkedList linkedList2 = new LinkedList(linkedList1);
        for (Object o : linkedList2) {
            System.out.println(o);
        }
    }
}
