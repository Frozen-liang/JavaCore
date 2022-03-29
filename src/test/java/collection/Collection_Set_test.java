package collection;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Iterator;

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

    class HashSet树化{
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
}
