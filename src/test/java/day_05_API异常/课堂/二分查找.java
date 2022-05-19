package day_05_API异常.课堂;

import org.junit.Test;

public class 二分查找 {
    @Test
    public void 数组() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int num = 3;

        int search = search(arr, num);
        System.out.println("元素" + num + "在数组的第" + search + "位置");
    }

    public int search(int[] arr,int num){
        int min = 0;
        int max = arr.length - 1;

        while (max>min){
            int mid = (min + max) / 2;

            if (arr[num] > arr[mid]) {
                // 当num > mid 说明查找的数在右边
                min = mid;
            } else if (arr[num] < arr[mid]) {
                // 当num < mid 说明查找的速在左边
                max = mid;
            } else if (arr[num] == arr[mid]) {
                // 当num == mid 说明找到元素
                return mid;
            }
        }

        return -1;
    }
}
