package leetCode;

import ann.FinishAnno;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem_13_RomanToInt
 * @Description LeetCode第13题：罗马数字转整数
 * @Author Hongyang Gu
 * @Date 2021/12/1 1:36 下午
 */
@FinishAnno(true)
public class Problem_13_RomanToInt {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
     * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     * 示例1:
     * 输入:s = "III"
     * 输出: 3
     *
     * 示例2:
     * 输入:s = "IV"
     * 输出: 4
     *
     * 示例3:
     * 输入:s = "IX"
     * 输出: 9
     *
     * 示例4:
     * 输入:s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     *
     * 示例5:
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 提示：
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     */

    public static int romanToInt(String s) {
        Map<String, Integer> romNumberMap = new HashMap<>();
        romNumberMap.put("I", 1);
        romNumberMap.put("V", 5);
        romNumberMap.put("X", 10);
        romNumberMap.put("L", 50);
        romNumberMap.put("C", 100);
        romNumberMap.put("D", 500);
        romNumberMap.put("M", 1000);
        int totalNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            int thisNumber = romNumberMap.get(String.valueOf(s.charAt(i)));
            int nextNumber = 0;
            if (i + 1 < s.length()){
                nextNumber = romNumberMap.get(String.valueOf(s.charAt(i + 1)));
            }
            totalNumber += thisNumber < nextNumber ? - thisNumber : thisNumber;
        }
        return totalNumber;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
    /**
     * 方案1：
     *  将罗马字母及对应的数字，存放在map中，遍历字符串。根据字符串当前以及下一个(如果存在)的罗马字母值获取对应数字，如果当前数字小于下一个数字，则当前为负数，否则为整数，进行累加O(n)
     */
}
