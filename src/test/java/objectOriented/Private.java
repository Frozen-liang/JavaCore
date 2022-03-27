package objectOriented;

import org.junit.Test;

/**
 * @date 2022/3/24 - 18:10
 *
 * 私有属性 方法 只能在类内部类使用
 *
 * 私有属性可以间接被 类中方法调用 然后在调用类中的方法
 */

class B{
    public int i = 1;
    protected int m = 3;
    private final int j = 2;

//  公开可以访问 保护 私有方法
    public void g(){
        System.out.println("我是公有方法");
//        b();
//        s();
    }

//  保护可以访问 公开 私有方法
    protected void b(){
        System.out.println("我是保护方法");
//        g();
//        s();
    }

//  保护可以访问 公开 私有方法
    private void s(){
        System.out.println("我是私有方法");
        g();
        b();
    }

    public void show(){
        System.out.println(j);
    }
}

public class Private {
    @Test
    public void test(){
        B b = new B();
        System.out.println(b.i);
//        System.out.println(b.j);
        b.show();   // 想要访问私有成员j 只能在类中创建方法 去获取 因为在类内部所有属性都是透明的
        System.out.println(b.m);

        b.b();
        b.g();
//        b.s();
    }
}
