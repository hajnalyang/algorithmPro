package merge;

//求数组中有多少逆序对-->后面的数组比当前的数字大
public class HighPair {
    public static int getHighPair(int[] arr){
        if (arr == null || arr.length < 2) return 0;
        int length = arr.length;
        int step  = 1;
        int res = 0;
        while (step < length){
            int left = 0;
            while (left < length){
                int mid = left + step - 1;
                if (mid >= length) break;
                int right = Math.min(mid + step, length - 1);
                res += halfSort(arr, left, mid, right);
                left = right + 1;
            }
            if (step > length / 2)break;
            step <<= 1;
        }
        return res;
    }

    public static int halfSort(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int pl = mid;
        int pr = right;
        int index = help.length - 1;
        int res = 0;
        while (pl >= left && pr >= mid + 1){
            res += arr[pl] > arr[pr] ? (pr - mid) : 0;
            help[index--] = arr[pl] > arr[pr] ? arr[pl--] : arr[pr--];
        }
        while (pl >= left){
            help[index--] = arr[pl--];
        }
        while (pr >= mid + 1){
            help[index--] = arr[pr--];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }


    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
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
            if (getHighPair(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
//        int[] arr = {4, 1, 3, 5};
//        System.out.println(getHighPair(arr));
    }
}
