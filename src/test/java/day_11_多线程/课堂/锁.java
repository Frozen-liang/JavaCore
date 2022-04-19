package day_11_多线程.课堂;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class 锁对象 implements Callable<String> {

    // 创建共有属性
    static int ticket = 100;
    // 创建共有对象用来加锁
    static Object object = new Object();

    @Override
    public String call() throws InterruptedException {
        while (true) {
            synchronized (object) {
                Thread.sleep(10);
                if (ticket <= 0)
                    break;
                ticket--;
                System.out.println(Thread.currentThread() + "卖出了第" + ticket);
            }
        }
        return "票卖完了";
    }
}

class 锁方法 implements Callable<String> {
    // 不用静态修饰
    private int ticket = 100;

    @Override
    public String call() {
        while (true) {
            if (!sell())
                break;
        }
        return "票卖完了";
    }

    // 锁方法进行买票
    public synchronized boolean sell() {
        if (ticket == 0)
            return false;
        ticket--;
        System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket);
        return true;
    }
}

public class 锁 {

    @Test
    public void 锁对象() throws ExecutionException, InterruptedException {
        // 创建对象
        Callable<String> callable = new 锁对象();

        // 创建对象
        FutureTask<String> futureTask1 = new FutureTask<>(callable);
        FutureTask<String> futureTask2 = new FutureTask<>(callable);
        FutureTask<String> futureTask3 = new FutureTask<>(callable);

        // 创建并启动三个线程
        new Thread(futureTask1, "携程").start();
        new Thread(futureTask2, "飞猪").start();
        new Thread(futureTask3, "美团").start();

    }

    @Test
    public void 锁方法() throws ExecutionException, InterruptedException {

        Callable<String> callable = new 锁方法();

        FutureTask<String> futureTask1 = new FutureTask<>(callable);
        FutureTask<String> futureTask2 = new FutureTask<>(callable);
        FutureTask<String> futureTask3 = new FutureTask<>(callable);

        new Thread(futureTask1, "携程").start();
        new Thread(futureTask2, "飞猪").start();
        new Thread(futureTask3, "美团").start();

//        System.out.println(futureTask1.get());
    }
}