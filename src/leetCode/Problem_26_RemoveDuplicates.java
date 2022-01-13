package leetCode;

import ann.FinishAnno;
import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * @ClassName Problem_26_RemoveDuplicates
 * @Description LeetCode第26题：删除有序数组中的重复项
 * @Author Hongyang Gu
 * @Date 2021/12/8 11:18 上午
 */
@FinishAnno(true)
public class Problem_26_RemoveDuplicates {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *      print(nums[i]);
     * }
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }else if (nums.length == 1){
            return 1;
        }
        int length = nums.length;
        int num = nums.length;
        while (num-- > 0){
            for (int i = 0; i < length; i++) {
                if (i + 1 == length){
                    break;
                }
                if (nums[i] == nums[i + 1]){
                    deleteNum(nums, i);
                    length -= 1;
                    break;
                }
            }
        }
        return length;
    }

    public static void deleteNum(int[] nums, int index){
        for (int i = 0; i < nums.length; i++) {
            if (i >= index && i + 1 < nums.length) {
                nums[i] = nums[i+1];
            }
        }
        nums[nums.length - 1] = 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 7};
//        deleteNum(nums, 2);
//        System.out.println(Arrays.toString(nums));
        int i = removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + "\t");
        }
    }
}
