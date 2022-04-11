package day_08_集合.heima.例题;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class seat_08 {

    @Test
    public void HashMap_统计字符串的字符出现次数(){
        HashMap<Character, Integer> map = new HashMap<>();

        String s = "You have to be open to love.";
        // 字符串变为数组
        char[] chars = s.toCharArray();
        for (char c : chars) {
//            if (!map.containsKey(c)){
//                map.put(c,1);
//            }else {
//                // 获取value
//                Integer integer = map.get(c);
//                integer++;
//                map.put(c,integer);

                // 三元运算符
                map.put(c,!map.containsKey(c) ? 1:map.get(c)+1);
            }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"出现了"+value+"次");
        }
    }

    @Test
    public void TreeMap_排序(){

    }
}
