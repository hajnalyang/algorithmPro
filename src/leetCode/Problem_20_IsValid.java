package leetCode;

import ann.FinishAnno;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem_20_IsValid
 * @Description LeetCode第20题：有效的括号
 * @Author Hongyang Gu
 * @Date 2021/12/1 6:11 下午
 */
@FinishAnno(true)
public class Problem_20_IsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 示例1：
     * 输入：s = "()"
     * 输出：true
     * 示例2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例3：
     * 输入：s = "(]"
     * 输出：false
     * 示例4：
     * 输入：s = "([)]"
     * 输出：false
     * 示例5：
     * 输入：s = "{[]}"
     * 输出：true
     */

    public static boolean isValid(String s) {
        Map<String, String> compare = new HashMap<>();
        compare.put(")", "(");
        compare.put("]", "[");
        compare.put("}", "{");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                sb.append(str);
            } else {
                if (sb.length() <= 0) {
                    return false;
                }
                String compareStr = String.valueOf(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
                if (compare.get(str).equals(compareStr)) {
                    continue;
                } return false;
            }
        }
        return sb.length() <= 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
