package day_08_集合.老师作业.作业;

import org.junit.Test;

import java.util.*;

public class 编程题一 {
    @Test
    public void test1() {
        TreeSet<String> treeSet1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        treeSet1.add("异步图书");
        treeSet1.add("电子工业出版社");
        treeSet1.add("清华大学出版社（清华）");
        treeSet1.add("异步图书（）");

        TreeSet<String> treeSet2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        treeSet2.add("恋爱");
        treeSet2.add("程序设计");
        treeSet2.add("人民邮电出版社");
        treeSet2.add("中国电力出版社）");

        HashMap<String, TreeSet<String>> hashMap = new HashMap<>();
        hashMap.put("品牌", treeSet1);
        hashMap.put("其他出版社", treeSet2);

        Set<Map.Entry<String, TreeSet<String>>> entries = hashMap.entrySet();
        entries.stream().forEach((stringTreeSetEntry -> stringTreeSetEntry.getKey()));

        for (Map.Entry<String, TreeSet<String>> entry : entries) {
            String key = entry.getKey();
            TreeSet<String> value = entry.getValue();
            for (String s : value) {
                System.out.println(key + "---" + s);
            }
        }
    }
}
