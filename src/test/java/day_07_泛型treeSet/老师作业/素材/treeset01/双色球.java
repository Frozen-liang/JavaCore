package day_07_泛型treeSet.老师作业.素材.treeset01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class 双色球 {
    @Test
    public void 抽号码() {

        // 创建一个Random对象，用于生成随机数
        Random random = new Random();

        // 生成一个蓝球号码
        int blueBall = random.nextInt(16) + 1;

        // 创建一个TreeSet集合对象，用来存储双色球数据
        TreeSet<Integer> redBalls = new TreeSet<Integer>();

        // 生成红球
        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }

        // 输出结果
        System.out.println("红球：" + redBalls + " | 蓝球：" + blueBall);

    }


}
