package bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class KM {

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void mapCreater(HashMap<Integer, Integer> map) {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }

    public static int findKM(int[] arr, int k, int m){
        if (map.size() == 0) {
            mapCreater(map);
        }
        int[] t = new int[32];
        for (int num : arr) {
            while (num != 0){
//                int rightOne = num & (-num);
//                t[rightOne - 1] ++;
//                num ^= rightOne;
                int rightOne = num & (-num);
                t[map.get(rightOne)]++;
                num ^= rightOne;
            }
        }
        int res = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % m != 0){
                if (t[i] % m == k){
                    //位或： 1|1=1  1|0=1  0|1=1  0|0=0
                    // 0000 0000 0000
                    // 0000 0001 0000
                    //------------------位或
                    // 0000 0001 0000
                    // 0000 0010 0000
                    //------------------位或(将结果进行累加)
                    // 0000 0011 0000
                    res |= (1 << i);
                } else {
                    return -1;
                }
            }
        }
        if (res == 0){
            int count = 0;
            for (int i : arr) {
                if (i == res){
                    count ++;
                }
            }
            return count != k ? -1 : res;
        }
        return res;
    }

    public static int[] generatorArray(int kinds, int k, int m, int maxValue){
        int[] arr = new int[k + (kinds - 1) * m];
        int kNum = genRandomNumber(maxValue);
        int index = 0;
        for (; index < k; index++) {
            arr[index] = kNum;
        }
        kinds--;
        HashSet<Integer> set = new HashSet<>();
        while (kinds > 0){
            int mNum = 0;
            do {
                mNum = genRandomNumber(maxValue);
            } while (set.contains(mNum));
            set.add(mNum);
            for (int i = 1; i <= m; i++) {
                arr[index] = mNum;
                index ++;
            }
            kinds --;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int genRandomNumber(int maxValue){
        return ((int) (Math.random() * maxValue + 1)) - ((int) (Math.random() * maxValue + 1));
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 2, 3, 3, 3};
//        System.out.println(findKM(arr, 2, 3));
        int k = (int)(Math.random() * 10) + 1;
        int m = (int)(Math.random() * 10) + 1;
        m = k == m ? m + 1 : m;
        int[] arr = generatorArray(5, k, m, 500);
        System.out.println(findKM(arr, k, m));
    }
}
