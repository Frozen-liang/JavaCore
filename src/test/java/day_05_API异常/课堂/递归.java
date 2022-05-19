package day_05_API异常.课堂;

import org.junit.Test;

public class 递归 {
    @Test
    public void 阶乘() {
        long i = getJc(100);
        System.out.println(i);
    }

    public long getJc(long i) {
        if (i == 1) {
            return 1;
        } else {
            return i * getJc(i - 1);
        }
    }

    @Test
    public void 斐波那契额(){
        int i = fbnq(20);
        System.out.println(i);
    }

    public int fbnq(int i){
        if (i == 1 || i ==2 )
            return 1;
        return fbnq(i-1) +fbnq(i-2);
    }
}
