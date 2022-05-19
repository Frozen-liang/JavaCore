package day_05_API异常.课堂;

import org.junit.Test;

import java.util.Arrays;

public class 冒泡排序 {
    @Test
    public void 数组() {
        int[] arr = {2, 5, 6, 3, 4, 1};

        // j是外层循环 累计需要比较的次数
        for (int j = 0; j < arr.length - 1; j++) {
            // i是数组的下标
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
