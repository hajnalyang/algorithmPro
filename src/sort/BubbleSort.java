package sort;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {
    public static int[] sort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int count = 0;
        boolean change = false;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                    change = true;
                }
                count ++;
            }
            if (!change){
                break;
            }
        }
        System.out.println(count);
        return arr;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null) || (arr1.length != arr2.length)){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static int[] copy(int[] arr){
        if (arr == null){
            return null;
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue){
        int size = (int) (Math.random() * maxSize) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * maxValue) + 1) - ((int) (Math.random() * maxValue));
        }
        return arr;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            int[] arr = generateRandomArray(10, 10);
//            int[] arrCopy = copy(arr);
//            Arrays.sort(arrCopy);
//            if (!isEqual(sort(arr), arrCopy)){
//                System.out.println("测试错误");
//            }
//        }
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }
}
