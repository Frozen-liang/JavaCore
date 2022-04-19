package day_12_线程池.课堂;

import org.junit.Test;

import java.io.PrintWriter;
import java.util.WeakHashMap;
import java.util.concurrent.*;

public class 四大线程池 {

    @Test
    public void newCachedThreadPool() {
        // 创建无边界线程池对象 map集合存储线程
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 操作 创建线程
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "被执行"));

        executorService.submit((() -> System.out.println(Thread.currentThread().getName() + "被执行")));

        // 关闭线程池
        executorService.shutdown();

    }

    @Test
    public void newFixedThreadPool() {
        // 创建有边界线程池对象 默认初始值为0 参数是最大的线程数量
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 操作 创建线程
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "被执行"));

        executorService.submit((() -> System.out.println(Thread.currentThread().getName() + "被执行")));

        // 关闭线程池
        executorService.shutdown();

    }

    @Test
    public void newScheduledThreadPool() {
        // 创建延迟有边界线程池对象 默认初始值为0 参数是最大的线程数量
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 操作 创建线程
        // 单次延迟
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println(Thread.currentThread().getName() + "被执行"),
                1,
                2,
                TimeUnit.SECONDS);

        // 周期性延迟
        scheduledExecutorService.scheduleWithFixedDelay((() -> System.out.println(Thread.currentThread().getName() + "被执行")),
                1,
                2,
                TimeUnit.SECONDS);

        // 关闭线程池
        scheduledExecutorService.shutdown();

    }

    @Test
    public void newSingleThreadExecutor() {
        // 创建单一线程池对象 只有一条线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 操作 创建线程
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "被执行"));
        executorService.submit((() -> System.out.println(Thread.currentThread().getName() + "被执行")));

        // 关闭线程池
        executorService.shutdown();

    }

    @Test
    public void ThreadPoolExecutor() {
        // 创建自定义线程池
        // 参数
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        3,
                        5,
                        2,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()    // 默认执行 抛弃 并丢出异常
                );

        // 操作
        for (int i = 0; i < 16; i++) {
            threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "被执行了"));
        }

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
