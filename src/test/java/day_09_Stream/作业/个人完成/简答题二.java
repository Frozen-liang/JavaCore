package day_09_Stream.作业.个人完成;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 简答题二 {
    // 流使用次数
    @Test
    public void test1() {
        List<String> list = Arrays.asList("梁杰栋", "罗志祥", "周杰伦");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = list.stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
        // 流只能使用一次
        stream1.forEach(System.out::println);

    }

    // Arrays.asList创建的集合只能看不能操作
    @Test
    public void test2() {
        // 创建一个List集合对象
        List<String> list = Arrays.asList("hello", "java8", "stream");

        // UnsupportedOperationException
//        list.add("world");                          // 向list集合中添加元素

// 获取上述list集合所对应的流对象
        // 将流中的元素转换成大写
        list.stream().map(String::toUpperCase).forEach(System.out::println);            // 遍历流中的元素
    }
}
