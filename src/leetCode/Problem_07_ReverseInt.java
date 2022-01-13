package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_07_ReverseInt
 * @Description LeetCode第7题：整数反转
 * @Author Hongyang Gu
 * @Date 2021/12/1 11:03 上午
 */
@FinishAnno(true)
public class Problem_07_ReverseInt {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31, 2^31− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     *
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     *
     * 示例 3：
     * 输入：x = 120
     * 输出：21
     *
     * 示例 4：
     * 输入：x = 0
     * 输出：0
     */
    public static int reverse(int x) {
        String number = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        int minIndex = 0;
        if (x < 0){
            minIndex = 1;
            sb.append("-");
        }
        boolean flag = true;
        for (int i = number.length() -1 ; i >= minIndex; i--) {
            char last = '0';
            if (flag){
                if (minIndex == 1) {
                    if (sb.length() > 1){
                        last = sb.charAt(1);
                    }
                } else {
                    if (sb.length() >= 1){
                        last = sb.charAt(0);
                    }
                }
                if (last == '0' && number.charAt(i) == '0') {
                    continue;
                }
                flag = false;
            }
            sb.append(number.charAt(i));
        }
        if (sb.length() <= 0){
            sb.append("0");
        }
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e){
            return 0;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(1234567899));
    }
    /**
     * 方案1：
     * 将整数转为字符串，将字符串进行遍历，翻转整数
     */

}
