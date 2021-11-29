package sort;

import java.util.Arrays;

//选择排序-->每次选择现有链表中，最小的元素与当前未排序的第一个位置进行交换
public class SelectSort {
    public static int[] sort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
//        int[] arr2 = BaseSort.copy(arr);
//        Arrays.sort(arr2);
//        for (int i = 0; i < 100; i++) {
//            if (!BaseSort.isEqual(sort(arr), arr2)){
//                System.out.println("测试失败");
//            }
//        }
        System.out.println(Arrays.toString(sort(arr)));
    }
}
