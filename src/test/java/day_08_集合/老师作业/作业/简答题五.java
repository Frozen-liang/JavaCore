package day_08_集合.老师作业.作业;

import org.junit.Test;

public class 简答题五 {
    public String show(int age, String... name) {
        return name+"已经"+age+"个年头了";
    }

    @Test
    public void test1() {
//        请分析下述程序存在的问题并说明原因？
        String name = "梁杰栋";
        // 可变参数语法位置一定是在所有参数的最后面 输出的是地址符号
        System.out.println(show(24,name));
    }
}
