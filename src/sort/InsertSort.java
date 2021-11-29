package sort;

import java.util.Arrays;

//插入排序
public class InsertSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]){
                    swap(arr, j + 1, j);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = BaseSort.generateRandomArray(10, 10);
        int[] arr2 = BaseSort.copy(arr);
        Arrays.sort(arr2);
        for (int i = 0; i < 100; i++) {
            if (!BaseSort.isEqual(sort(arr), arr2)){
                System.out.println("测试失败");
            }
        }
//        System.out.println(Arrays.toString(sort(arr)));
    }
}
