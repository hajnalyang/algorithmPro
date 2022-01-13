package leetCode;

import ann.FinishAnno;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Problem_28_StrStr
 * @Description LeetCode第28题：实现strStr
 * @Author Hongyang Gu
 * @Date 2021/12/15 5:52 下午
 */
@FinishAnno
public class Problem_28_StrStr {
    /**
     * 实现 strStr() 函数。
     *
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     *
     * 说明：
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     * 示例 1：
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     * 示例 2：
     * 输入：haystack = "aaaaa", needle = "bba"
     * 输出：-1
     * 示例 3：
     * 输入：haystack = "", needle = ""
     * 输出：0
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() <= 0 ) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int index = -1;
        String firstStr = Character.toString(needle.charAt(0));
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < haystack.length(); i++) {
            String temp = Character.toString(haystack.charAt(i));
            if (temp.equals(firstStr)) {
                indexList.add(i);
            }
        }
        boolean flag = true;
        for (Integer thisIndex : indexList) {
            index = thisIndex;
            int needleIndex = 0;
            for (int i = thisIndex; i < haystack.length(); i++) {
                if (needleIndex < needle.length()) {
                    if (Character.toString(haystack.charAt(i)).equals(Character.toString(needle.charAt(needleIndex)))) {
                        needleIndex ++;
                    } else {
                        index = -1;
                        break;
                    }
                } else {
                    return index;
                }
            }
            if (haystack.length() == needle.length()) {
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
