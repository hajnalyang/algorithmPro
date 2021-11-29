package ListAndMap;

public class FindMaxValue {
    public static int maxvalue(int[] arr, int left, int right){
        if (left == right) return arr[left];
        int mid = left + ((right - left) >> 1);
        int leftMaxValue = maxvalue(arr, left, mid);
        int rightMaxValue = maxvalue(arr, mid + 1, right);
        return Math.max(leftMaxValue, rightMaxValue);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 2, 4, 1};
        System.out.println(maxvalue(arr, 0, arr.length - 1));
    }
}
