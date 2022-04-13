package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("all")
// Map map = new Map(); 接口实现的是子类
public class Collection_test_Map {

    @Test
    public void Collection_HashMap_简单使用() {
        HashMap hashMap = new HashMap();
        // key 和 Vaule 都是Object
        hashMap.put("l", 1);
        hashMap.put("ljdd", 1);      // vaule可以重复 因为key会重新找一个table索引
        hashMap.put("lj", 2);
        hashMap.put("ljd", 3);
        hashMap.put("ljd", 1);       // 替换机制 替换key为”ljd“ 中的vaule 替换为最后输入的值
        hashMap.put(null, null);
        hashMap.put(null,"n");

        System.out.println(hashMap.get("ljd"));
        System.out.println(hashMap.size());
        System.out.println(hashMap.containsKey("ljd"));

        // 取出来是无序的 因为Key随机生成哈希值
        System.out.println(hashMap);
    }

    @Test
    public void Collection_HashMap_源码() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "ljd");
        hashMap.put(2, "fy");

        // tab[i] = newNode(hash, key, value, null);
        // Node<K,V> newNode
        // 自动创建EntrySet集合方便遍历 存放Entry对象 面对接口编程
        // Entry对象包含了K，V
        // Set<Map.Entry<K,V>>
        // static class Node<K,V> implements Map.Entry<K,V>  K getKey(); V getValue();

        Set set = hashMap.entrySet();
        for (Object o : set) {
            // 把set向下转型为Map.Entry
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    public void Collection_HashMap_遍历() {
        HashMap hashMap = new HashMap();
        hashMap.put("l", 1);
        hashMap.put("ljdd", 1);
        hashMap.put("lj", 2);
        hashMap.put("ljd", 3);
        hashMap.put("ljd", 1);
        hashMap.put(null, null);
        System.out.println(hashMap.containsKey("l"));
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
        System.out.println(hashMap.get("l"));
        System.out.println(hashMap.replace("l", 111111));

        // 遍历取出Key
        Set key = hashMap.keySet();

        // 增强For
        System.out.println("增强For输出-------------------------------");
        for (Object o : key) {
            System.out.println(key + " " + hashMap.get(key));
        }

        // iterator迭代器
        Iterator iterator = key.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + " " + hashMap.get(next));
        }
        System.out.println("----------------------");

        // Collection values = hashMap.values();

        // entrySet
        Set set1 = hashMap.entrySet();
        for (Object entry : set1) {
            Map.Entry entry1 = (Map.Entry) entry;
        }

        System.out.println("-----------------------------");

        Set set2 = hashMap.entrySet();
        Iterator iterator1 = set2.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();   // Object o = class java.util.HashMap$Node
            System.out.println(o);
        }

    }

    class Collection_HashMap_Em {
        private int id;
        private String name;
        private int sal;

        public Collection_HashMap_Em(int id, String name, int sal) {
            this.id = id;
            this.name = name;
            this.sal = sal;
        }

        @Override
        public String toString() {
            return "Collection_HashMap_Em{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sal=" + sal +
                    '}';
        }
    }

    @Test
    public void Collection_HashMap_例题() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new Collection_HashMap_Em(1, "ljd", 1800));
        hashMap.put(2, new Collection_HashMap_Em(2, "xy", 1000));
        hashMap.put(3, new Collection_HashMap_Em(3, "lss", 8800));

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            // 向下转型
            Map.Entry entry = (Map.Entry) iterator.next();   // Node 类型
            // 向下转型
            Collection_HashMap_Em en = (Collection_HashMap_Em) entry.getValue();
            if (en.sal >= 1800)
                System.out.println(entry);
        }
    }

    @Test
    public void Collection_HashTable() {
        // 线程安全 效率底
        Hashtable hashtable = new Hashtable();
        hashtable.put(1,"ljd");
        hashtable.put(2,"xy");
        hashtable.put(3,"lss");
//        hashtable.put(4,null);            value不能为空
        hashtable.put(1,"lss");         //  替换
//        hashtable.put(null,"lss");        key不能为空

        System.out.println(hashtable);
    }

    @Test
    public void Collection_Properties() {
        Properties properties = new Properties();
        properties.put(1,"ljd");
        properties.put(2,"xy");
        properties.put(3,"lss");
//        properties.put(4,null);            value不能为空
        properties.put(1,"lss");         //  替换机制
//        properties.put(null,"lss");        key不能为空

        System.out.println(properties);
    }

    @Test
    public void Collection_TreeMap(){
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,"ljd");
//        treeMap.put(null,null);
//        treeMap.put(null,"null");
//        treeMap.put("null",null);   都不能为空


    }
}
