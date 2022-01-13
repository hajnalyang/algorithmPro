package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_09_IsPalindrome
 * @Description LeetCode第9题：回文数
 * @Author Hongyang Gu
 * @Date 2021/12/1 11:57 上午
 */
@FinishAnno(true)
public class Problem_09_IsPalindrome {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     *
     * 示例2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 示例 4：
     * 输入：x = -101
     * 输出：false
     */
    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        for (int i = 0; i < number.length() / 2; i++) {
            int endIndex = number.length()- 1 - i;
            if (endIndex < i ){
                break;
            }
            if (number.charAt(i) == number.charAt(endIndex)){
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
    /**
     * 方案1：
     *  将数字转为字符串，对字符串进行遍历，使用"双指针"，对头尾进行比较判断O(n)
     */
}
