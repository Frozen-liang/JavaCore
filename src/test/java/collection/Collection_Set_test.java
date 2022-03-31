package collection;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeSet;

@SuppressWarnings("all")
public class Collection_Set_test {

    class Collection_Set_Dog {
        private final String name;

        public Collection_Set_Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Collection_Set_Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void Collection_test_HashSet简单操作() {

        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(1));
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        System.out.println(hashSet.add(1));
        // 添加null
        hashSet.add(null);
        // 添加字符串
        hashSet.add("ljd");
        hashSet.add("ljd");
        // 对象
        hashSet.add(new Collection_Set_Dog("ljd"));
        hashSet.add(new Collection_Set_Dog("ljd"));
        // 对象的字符串
        hashSet.add(new String("ljd"));
        hashSet.add(new String("ljd"));

        // 输出
//        System.out.println(hashSet);
//
//        Iterator iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.println(next);
//        }

        for (Object o : hashSet) {
            System.out.println(o);
        }

    }


    class Node {
        Object item;    // 存放数据
        Node next;      // 指向下一个节点

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    @Test
    public void Collection_test_HashSet结构实现() {
        // 数组 0~15
        Node[] table = new Node[16];

        Node l = new Node("l", null);
        table[2] = l;

        Node lj = new Node("lj", null);
        l.next = lj;
        Node ljd = new Node("ljd", null);
        lj.next = ljd;

        System.out.println(table);

    }

    class HashSet树化 {
        private int i;

        public HashSet树化(int i) {
            this.i = i;
        }

        // 保证HashCode都是一样的 就table后面可以链在一条
        @Override
        public int hashCode() {
            return 100;
        }
    }

    @Test
    public void Collection_test_HashSet扩容() {
        HashSet hashSet1 = new HashSet();
        // 扩容增加规则 增加任何
        for (int i = 0; i < 100; i++) {
            hashSet1.add(i);
        }
        // 树化
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < 12; i++) {
            hashSet2.add(new HashSet树化(i));
        }
        System.out.println(hashSet2);
    }

    /*
     * 一个员工类中 相同名字和年龄不能加入到集合中
     * */

    class Collection_Em {
        private String name;
        private int age;

        public Collection_Em(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Collection_Em{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        // 如果name 和 age 相同返回相同的哈希码
        @Override
        public int hashCode() {
            return Objects.hash(name, age);     // 先比较哈希码
        }

        @Override
        public boolean equals(Object o) {       // 再比较值
            if (this == o)
                return true;
            if (!(o instanceof Collection_Em))
                return false;
            Collection_Em that = (Collection_Em) o;
            return age == that.age && Objects.equals(name, that.name);
        }
    }

    @Test
    public void Collection_test_HashSet列题1() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Collection_Em("ljd", 10));
        hashSet.add(new Collection_Em("xy", 10));
        hashSet.add(new Collection_Em("ljd", 10));

        System.out.println(hashSet);
    }

    class LinkedHashSet_Car {
        private String name;
        private int price;

        public LinkedHashSet_Car(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LinkedHashSet_Car)) return false;
            LinkedHashSet_Car that = (LinkedHashSet_Car) o;
            return price == that.price && Objects.equals(name, that.name);
        }

        // 如果 哈希相同 但是父类的equals同样比较地址
        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }
    }

    @Test
    public void Collection_test_LinkedHashSet() {
        // 数组就是table 双向链表代表有序了 哈希值不同 值同 添加到屁股后面
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(1);

        // 添加顺序和取出数据顺序也是一致的
        System.out.println(linkedHashSet);
    }

    @Test
    public void Collection_() {

        //        TreeSet treeSet = new TreeSet();

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        treeSet.add("ljd");
        treeSet.add("xy");
        treeSet.add("lss");

        System.out.println(treeSet);
    }

    @Test
    public void Collection_TreeSet(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
    }
}
