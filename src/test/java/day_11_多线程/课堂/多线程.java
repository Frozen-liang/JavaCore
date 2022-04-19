package day_11_多线程.课堂;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class 多线程1_继承_Thread extends Thread {

    // run 是一个事件
    @Override
    public void run() {
        // 获取名称
        System.out.println(getName());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class 多线程2_实现_Runnable implements Runnable {

    // run 是一个事件
    @Override
    public void run() {
        // 获取名称
        System.out.println(Thread.currentThread());
        // 事件
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class 多线程3_实现_Callable implements Callable {
    int sum;

    @Override
    public Object call() {
        // 获取名称
        System.out.println(Thread.currentThread());

        // 事件
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}

public class 多线程 {

    // 继承Thread类实现
    @Test
    public void test1() {
        // 创建线程对象 并且设置名称
        Thread thread1 = new 多线程1_继承_Thread();
        thread1.setName("梁杰栋");
        // 创建多线程对象
        Thread thread2 = new 多线程1_继承_Thread();
        thread2.setName("罗志祥");

        // 操作 启动线程 这个是雇的帮手
        thread1.start();
        thread2.start();
    }

    // 实现Thread接口实现
    @Test
    public void test2() {
        // 创建实现事件对象
        Runnable runnable = new 多线程2_实现_Runnable();
        // 创建线程对象 设置名称
        Thread thread1 = new Thread(runnable, "梁杰栋");
        Thread thread2 = new Thread(runnable, "罗志祥");

        // 操作 启动线程
        thread1.start();
        thread2.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    // 实现Thread接口实现
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        // 创建实现事件对象
        Callable<Integer> callable = new 多线程3_实现_Callable();

        // 创建调用接口方法对象
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 创建线程对象 设置名称
        Thread thread1 = new Thread(futureTask, "梁杰栋");

        // 启动线程
        thread1.start();

        // 获取值
        System.out.println(futureTask.get());
    }

}
