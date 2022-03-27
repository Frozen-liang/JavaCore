package Object;

import org.junit.Test;

/**
@date 2022/3/24 - 16:17
*/

class Equals2{
    private final int i;

    public Equals2(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {	// 重写父类的方法 参数是对象  obj是父类指针 传子类对象进来的时候 指向子类 （父类已经指向子类equals可以强制转换）
                                        // 父类指向子类equals 可以调用子类中和父类相同的方法 但是不能调用子类中特有的属性i
        Equals2 e = (Equals2)obj; 		// 为了调用子类特有的属性i 强制父类转换为子类

        if ( this.i == e.i ) {			// 当前对象(e1)的i 和 obj(e2)指向的i 比较
            return true;
        } else {
            return false;
        }
    }
}

public class Equals {
    @Test
    public void test1(){
        Equals2 e2 = new Equals2(1);
        Equals2 e22 = new Equals2(1);
        System.out.println("改写父类的equals()让其比较的是内容：");
        System.out.println(e2.equals(e22));
        System.out.println("");
    }

    @Test
    public void test2(){
        String s1 = "liang";	// "liang":unincode 16位 2字节	字符串在data区存放 s1和s2在栈中存放 同时指向数据区里面的"liang"区域
        String s2 = "liang";
        System.out.println("在字符常量池中 equals() 比较内容:");
        System.out.println(s1.equals(s2));
        if ( s1 == s2 ) {
            System.out.println("在字符常量池中 = 比较的是内容");
        } else {
            System.out.println("在字符常量池中 = 比较的是地址");
        }
        System.out.println("");
    }

    @Test
    public void test3(){
        String s3 = new String("liang");	// "liang":unincode 16位 2字节 对象在堆中存放 s1和s2在栈中存放 指向不同堆中两块 "liang"区域
        String s4 = new String("laing");

        System.out.println("在堆中 equals 比较的是地址:");
        System.out.println(s3.equals(s4));

        if ( s3 == s4 ) {
            System.out.println("在堆中 = 比较的是内容");
        } else {
            System.out.println("在堆中 = 比较的是地址");
        }
    }
}
