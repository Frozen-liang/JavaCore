package objectOriented;

import org.junit.Test;

/**
 * @date 2022/3/29 - 21:53
 */
@SuppressWarnings("all")
public class InnerClass {

    // 局部内部类
    @Test
    public void LocalInner() {
        LocalInner localInner = new LocalInner(100);
        localInner.f2();
    }

    // 匿名类
    @Test
    public void AnonymousInnerClass() {

        //  接口使用 实现
        AnonymousInnerClass_interface anInterface = new AnonymousInnerClass_interface();
        anInterface.f();
        //  类使用
        //  普通类  继承
        AnonymousInnerClass_Class aClass = new AnonymousInnerClass_Class("xy") {
            @Override
            public void f() {
                System.out.println("ljd");
            }
        };
        aClass.f();

        // 抽象类
        new AnonymousInnerClass_abstract_Class() {

            @Override
            public void f1() {
                System.out.println("抽象");
            }

            @Override
            public void f2(String name) {
                System.out.println(name);
            }
        }.f2("ljd");
    }

    //  成员(属性)内部类
    @Test
    public void Member_InnerClass() {
        Member_InnerClass memberInnerClass = new Member_InnerClass();
        memberInnerClass.f();
        // 非静态
        Member_InnerClass.MemberClass1 memberClass1 = memberInnerClass.new MemberClass1();  // new MemberClass1()作为一个成员
        System.out.println(memberClass1.j);

        // 静态
        Member_InnerClass.MemberClass2 memberClass2 = new Member_InnerClass.MemberClass2();
        memberClass2.f();
    }

    @Test
    public void test() {
        class Test {//外部类 public Test()
            { //构造器
                Inner s1 = new Inner();
                s1.a = 10;
                Inner s2 = new Inner();
                System.out.println(s2.a);
            }

            class Inner { //内部类，成员内部类
                public int a = 5;
            }
        }

        Test t = new Test();
        Test.Inner inner = t.new Inner();//5
        System.out.println(inner.a);//5
    }
}

class Member_InnerClass {
    private int i = 100;
    public static int j = 200;

    public void f() {
        MemberClass1 member = new MemberClass1();
        member.f();
    }

    // 成员内部类
    public class MemberClass1 {
        private int i = 800;
        public int j = 800;

        public void f() {
            System.out.println(i);
            System.out.println(Member_InnerClass.this.i);
            System.out.println(Member_InnerClass.this.i);
        }
    }

    // 静态内部类
    static class MemberClass2 {
        public void f() {
            System.out.println("我是静态成员内部类");
            System.out.println(j);
        }
    }
}

// --------------------------------------------------------------------------------------------------------------------

class LocalInner {

    private int i = 100;

    public LocalInner(int i) {
        this.i = i;
    }

    private void f1() {
        System.out.println("我是外部类的私有方法");
    }

    public void f2() {
//  类方法中 局部内部类
        class Inner1 {
            //  内外部属性方法重名 就近原则
            private int i = 800;

            public void f() {
//  直接访问私有成员
                System.out.println("局部内部类调用外部类的私有属性 " + i);
//  调用外部类的属性
                System.out.println(LocalInner.this.i);
                f1();
            }
        }
//  可以继承
        class Inner2 extends Inner1 {

        }

//  使用内部类
        Inner1 inner1 = new Inner1();
        inner1.f();

        Inner2 inner2 = new Inner2();
    }
}

// ------------------------------------------------------------------------------

interface tiger {
    void cry();
}

class AnonymousInnerClass_interface {
    private int i = 100;

    public void f() {
        tiger tiger = new tiger() {
            private int i = 800;

            @Override
            public void cry() {
                System.out.println("我是匿名类 " + i);
                System.out.println("我是匿名类 " + AnonymousInnerClass_interface.this.i);
            }
        };
        tiger.cry();
    }
}

class AnonymousInnerClass_Class {

    private String name;

    public AnonymousInnerClass_Class(String name) {
        this.name = name;
    }

    public void f() {
        System.out.println(name);
    }
}

abstract class AnonymousInnerClass_abstract_Class {

    abstract public void f1();

    abstract public void f2(String name);
}


