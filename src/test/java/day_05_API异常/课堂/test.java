package day_05_API异常.课堂;

import org.junit.Test;

public class test {
    @Test
    public void test1() {
        // 空指针异常
        int[] arr = null;

        try {
            // 空指针异常
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            // 算术异常
            int i = 1 / 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("无论怎样我都会执行");
        }
        System.out.println("我被执行了");
    }

    @Test
    public void 自定义异常() throws Throwable {
        // 自定义一个算术异常
        try {
            int i = 1/0;
        }catch (ArithmeticException e){
            throw new ljdException().show();
        }

        System.out.println("我被执行了");
    }
}

class ljdException extends RuntimeException{
    public Throwable show(){
        System.out.println("算术异常");
        return new RuntimeException();
    }
}
