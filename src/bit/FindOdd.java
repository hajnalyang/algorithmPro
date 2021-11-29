package bit;

import java.util.Arrays;

public class FindOdd {
    public static int findOdd(int[] arr){
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        return result;
    }

    public static void findOdd2(int[] arr){
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        //找到两个出现奇数次的数异或的结果
        //找到两个数最后侧的1
        int rightOne = result & (-result);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            // 0110 1101 0000
            // 0000 0001 0000
            //----------------- &运算 1 & 1=1   0 & 0=0   1 & 0=0     0 & 1=0
            // 0000 0001 0000
            //如果等于0，说明该数字的rightOne位置上不是1，进行异或操作，将该数字累加仅onlyOne
            if ((arr[i] & rightOne) == 0){
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + "    " + (result ^ onlyOne));
    }

    public static int[] generatorArray(int kinds, int maxValue){
        int oddTimes = (int) (Math.random() * 10) * 2 - 1;
        int otherTimes = (int) (Math.random() * 10) * 2;
        int[] arr = new int[oddTimes + (otherTimes * kinds)];
        while (oddTimes > 0){
            arr[oddTimes] = genRandomNumber(maxValue);
            oddTimes--;
        }
        kinds --;
        for (int i = 1; i <= kinds; i++) {
            int num = genRandomNumber(maxValue);
            for (int j = 1; j <= otherTimes; j++) {
                arr[oddTimes + i * j] = num;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int genRandomNumber(int maxValue){
        return ((int) (Math.random() * maxValue + 1)) - ((int) (Math.random() * maxValue + 1));
    }

    public static void main(String[] args) {
//        int[] arr = generatorArray(4, 10);
//        System.out.println(findOdd(arr));
        int[] arr = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        findOdd2(arr);
    }
}
