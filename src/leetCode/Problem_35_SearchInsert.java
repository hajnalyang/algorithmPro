package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_35_SearchInsert
 * @Description LeetCode第35题：搜索插入位置
 * @Author Hongyang Gu
 * @Date 2022/2/16 5:14 下午
 */
@FinishAnno
public class Problem_35_SearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *
     * 示例2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     * 示例 4:
     * 输入: nums = [1,3,5,6], target = 0
     * 输出: 0
     *
     * 示例 5:
     * 输入: nums = [1], target = 0
     * 输出: 0
     */
    /**
     * int start = 0;
     *         int end = nums.length - 1;
     *         int middle = 0;
     *         while(start <= end){
     *             if(start == end){
     *                 if(start == 0){
     *                     return nums[start] >= target ? 0 :start + 1;
     *                 }
     *                 if(nums[start] >= target){
     *                     return start;
     *                 }
     *                 return start + 1;
     *             }
     *             middle = start + (end - start) / 2;
     *             if(nums[middle] < target){
     *                 start = middle + 1;
     *                 continue;
     *             } else if(nums[middle] > target){
     *                 end = middle - 1;
     *                 continue;
     *             } else {
     *                 return middle;
     *             }
     *         }
     *         return middle;
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
