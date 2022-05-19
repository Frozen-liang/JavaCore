package day_06_时间集合.老师作业.素材;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class 抓阄 {
    @Test
    public void list() {
        ArrayList<String> name = new ArrayList<>();
        name.add("梁杰栋");
        name.add("罗志祥");
        name.add("周杰伦");
        name.add("梁朝伟");
        name.add("大张伟");

        ArrayList<String> action = new ArrayList<>();
        action.add("喝一杯");
        action.add("喝两杯");
        action.add("喝三杯");
        action.add("喝四杯");
        action.add("喝五杯");

        for (String s : name) {
            Random random = new Random();
            // 随机数的时候要注意
            int index = random.nextInt(action.size());
            String remove = action.remove(index);
            System.out.println(s + "抓到的阄为" + remove);
        }


    }
}
