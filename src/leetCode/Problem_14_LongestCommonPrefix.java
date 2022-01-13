package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_14_LongestCommonPrefix
 * @Description LeetCode第14题：最长公共前缀
 * @Author Hongyang Gu
 * @Date 2021/12/1 2:13 下午
 */
@FinishAnno(true)
public class Problem_14_LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串""。
     *
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     * 提示：
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        int minLength = strs[0].length();
        for(String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        for (int i = 0; i < minLength; i++) {
            String temp = Character.toString(strs[0].charAt(i));
            for (int j = 0; j < strs.length; j++) {
                String everyTemp = Character.toString(strs[j].charAt(i));
                if (!temp.equals(everyTemp)){
                    return res.toString();
                }
            }
            res.append(temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
