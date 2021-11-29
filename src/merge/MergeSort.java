package merge;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2)return;
        int N = arr.length;
        int step = 1;
        while (step < N){
            int left = 0;
            while (left < N){
                if (step >= N - left){
                    break;
                }
                int mid = left + step - 1;
                int right = mid + Math.min(step, N - mid - 1);
                halfSort(arr, left, mid, right);
                left = right + 1;
            }
            //防止整形溢出
            if (step > N / 2){
                break;
            }
            //每次乘2
            step <<= 1;
        }
    }

    public static void testMergeSort(int[] arr){
        if (arr == null || arr.length < 2)return;
        //数组的长度
        int length = arr.length;
        //每次数组调整的步长
        int mergeStep = 1;
        while (mergeStep < length){
            //每次调整的步骤
            //每次调整步长完毕，新的最左下标为0
            int left = 0;
            //下标小于数组长度
            while (left < length){
                //左侧数组的最大下标
                int M = left + mergeStep - 1;
                //左侧数组凑不够，无需调整
                if (M >= length)break;
                //右侧数组的最大下标
                int right = Math.min(M + mergeStep, length - 1);
                halfSort(arr, left, M, right);
                left = right + 1;
            }
            if (mergeStep > length / 2)break;
            //步长每次乘2
            mergeStep <<= 1;
        }
    }



    public static void mergeSortFor(int[] arr){
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1);
    }

    //将arr[left .... right]排序
    //时间复杂度为o(N * logN)
    public static void sort(int[] arr, int left, int right){
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        //将left~mid和mid+1~right数组排序，此时左右两个数组都是有序的
        halfSort(arr, left, mid, right);
    }

    public static void halfSort(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int pl = left;
        int pr = mid + 1;
        while (pl <= mid && pr <= right){
            help[i++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }
        //左右数组有一组拷贝完毕
        //左半数组未完成拷贝
        while (pl <= mid){
            help[i++] = arr[pl++];
        }
        //右半数组未完成拷贝
        while (pr <= right){
            help[i++] = arr[pr++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
