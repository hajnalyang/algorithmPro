package merge;

//求小和问题-->数组中数字之前比该数字小的
public class LittleSum {
    public static int getLittleSum(int[] arr){
        if (arr == null || arr.length < 2) return 0;
        return sortGetSum(arr);
    }

    public static int sortGetSum(int[] arr){
        int length = arr.length;
        int step = 1;
        int res = 0;
        while (step < length){
            int left = 0;
            while (left < length){
                int mid = left + step - 1;
                if (mid >= length)break;
                //右侧数组最大下标
                int right = Math.min(mid + step, length - 1);
                res += getSum(arr, left, mid, right);
                left = right + 1;
            }
            if (step > length / 2)break;
            step <<= 1;
        }
        return res;
    }

    public static int getSum(int[] arr, int left, int mid, int right){
        if (arr == null || arr.length < 2)return 0;
        int[] help = new int[right - left + 1];
        int pl = left;
        int pr = mid + 1;
        int index = 0;
        int res = 0;
        while (pl <= mid && pr <= right){
            res += arr[pl] < arr[pr] ? (right - pr + 1) * arr[pl] : 0;
            help[index++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }
        while (pl <= mid){
            help[index++] = arr[pl++];
        }
        while (pr <= right){
            help[index++] = arr[pr++];
        }
        //将辅助数组中的元素拷贝进原数组中
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int a = getLittleSum(arr1);
            int b = comparator(arr2);
            if (a != b) {
                System.out.println(a);
                System.out.println(b);
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
