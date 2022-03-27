package objectOriented;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @date 2022/3/22 - 12:02
 */
class P {
    public void f() {
        System.out.println("我是父类的方法f");
    }
}

class P1 extends P {
    public void f() {
        System.out.println("我是子类p1");
    }
}

class P2 extends P {
    public void f() {
        System.out.println("我是子类p2");
    }

    public void g() {
        System.out.println("我是子类特有方法g");
    }
}

public class Polymorphic {
    public static void g(P p) {
        p.f();
    }

    public static void main(String[] args) {
        P p = new P();
        P1 p1 = new P1();
        P2 p2 = new P2();

    }

    @Test
    public void test1() {
        P p = new P();
        P1 p1 = new P1();
        P2 p2 = new P2();

        p.f();
        p1.f();
        p2.f();
        p2.g();
        System.out.println("");
    }

    @Test
    public void test2() {
        P p = new P();
        P1 p1 = new P1();
        P2 p2 = new P2();

//        System.out.println("把子类赋予超类，调用子类的特有方法");
//        p = p1;
//        p.f();
//        p = p2;
//        p.f();

//        System.out.println("父类强转给子类");
//        p2 = (P2)p;
//        p2.f();
//        p.f();

        System.out.println("通过多态 子类给父类 输出全部的f()方法");
        g(p);
        g(p1);
        g(p2);
    }
}
