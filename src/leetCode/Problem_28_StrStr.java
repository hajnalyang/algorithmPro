package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_28_StrStr
 * @Description LeetCode第28题：实现strStr
 * @Author Hongyang Gu
 * @Date 2021/12/15 5:52 下午
 */
@FinishAnno(value = true)
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
    /*
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
                        if (needleIndex == needle.length()){
                            return index;
                        }
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
        return -1;
    }
     */
    public static int strStr(String haystack, String needle) {
        // 当子串为空/子串长度为0时，返回0
        if (needle == null || needle.length() <= 0){
            return 0;
        }
        // 当父串为空/长度小于子串时，返回-1
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        char needleFirst = needle.charAt(0);
        // 遍历父串
        for (int i = 0; i < haystack.length(); i++) {
            char hayChar = haystack.charAt(i);
            // 如果当前字符与子串首个字符不一致，则继续向下遍历
            if (hayChar != needleFirst){
                continue;
            }
            // 如果当前字符匹配，但是父串剩余长度小于子串，则返回-1
            if (haystack.length() - i < needle.length()){
                break;
            }
            boolean flag = true;
            for (int j = 1; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "sippia";
        System.out.println(strStr(haystack, needle));
    }
}
