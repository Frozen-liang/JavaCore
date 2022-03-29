package objectOriented;

import org.junit.Test;

/**
 * @date 2022/3/29 - 21:53
 */
@SuppressWarnings("all")
public class InnerClass {
    @Test
    public void InnerClass_简介() {

    }
}

class OutClass {
    private int i = 100;

    public OutClass(int i) {
        this.i = i;
    }

    public void f() {
        System.out.println("f()");
    }

    class Inner {
        // 内部类
    }
}

class LocalInner {
    private int i = 100;

    public LocalInner(int i) {
        this.i = i;
    }

    private void f2(){
        System.out.println("我是私有方法");
    }

    public void f() {
        // 类方法中
        class Inner {
            public void f() {
                System.out.println("局部内部类调用私有属性" + i);
                f2();
            }
        }
    }
}
