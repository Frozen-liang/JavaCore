package objectOriented;

import org.junit.Test;

/**
 * @date 2022/3/22 - 10:32
 */
class A{
    int i;
    int j;
}

public class Object {
    @Test

    public void test1(){
        A aa = new A();
        /*
         *  aa
         *     （局部指针变量）
         *      栈（stack）静态分配
         *      自动释放
         *      引用堆中内存
         * new A()
         *      堆（heap）动态分配
         *      类似于（A*）malloc(sizeof(A))
         *      手动释放
         *
         */
        aa.i = 10;
        aa.j = 20;
        /*
        * aa.i 并没有i这个成员 堆中的地址也赋值给了aa 保存了成员的地址
        * */
        System.out.println(aa.i+" "+ aa.j);
    }

    @Test
    public void test2(){
        A aa1 = new A();
        A aa2 = new A();

        System.out.println(aa1.i = 10);
        System.out.println(aa2.i = 20);
    }

    @Test
    public void test3(){
        A aa1 = new A();
        A aa2 = new A();

        aa1.i = 10;
        aa2.i = 20;

        aa2 = aa1;

        System.out.println(aa1.i);
        System.out.println(aa2.i);
    }
}
