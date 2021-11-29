package leetCode;

import ann.FinishAnno;

import java.util.Arrays;

/**
 * @ClassName Problem_01_two_sum
 * @Description LeetCode第一题：两数相加
 * @Author Hongyang Gu
 * @Date 2021/10/26 3:55 下午
 */
@FinishAnno
public class Problem_01_TwoSum {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出:和为目标值 target  的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 提示：
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     */

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int[] twoSum = getTwoSum(nums, 6);
        System.out.println(Arrays.toString(twoSum));
    }

    public static int[] getTwoSum(int[] nums, int target){
        for (int index = 0; index < nums.length - 1; index++) {
            for (int j = index + 1; j < nums.length; j++) {
                if (nums[index] + nums[j] == target){
                    return new int[]{index, j};
                }
            }
        }
        return new int[]{};
    }
}
