package leetCode;

import ann.FinishAnno;

/**
 * @ClassName Problem_21_MergeTwoLists
 * @Description LeetCode第21题：合并两个有序链表
 * @Author Hongyang Gu
 * @Date 2021/12/1 6:28 下午
 */
@FinishAnno(true)
public class Problem_21_MergeTwoLists {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // 如果第一个链表的数值小于第二个链表的数值
                // 结果链表中，插入值小的那个链表的值
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }
        while (list1 != null) {
            temp.val = list1.val;
            list1 = list1.next;
            if (list1 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        while (list2 != null) {
            temp.val = list2.val;
            list2 = list2.next;
            if (list2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] first = new int[]{1,8};
        ListNode firstHead = new ListNode();
        ListNode temp = firstHead;
        StringBuilder firstNumber = new StringBuilder();
        for (int i : first) {
            firstNumber.append(i);
        }
        for (int index = 0; index < firstNumber.length(); index++) {
            temp.val = Integer.parseInt(Character.toString(firstNumber.charAt(index)));
            if (index != firstNumber.length() - 1){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        System.out.println();
        ListNode secondHead = new ListNode();
        temp = secondHead;
        int[] second = new int[]{0, 2};
        StringBuilder secondNumber = new StringBuilder();
        for (int i : second) {
            secondNumber.append(i);
        }
        for (int index = 0; index < secondNumber.length(); index++) {
            temp.val = Integer.parseInt(Character.toString(secondNumber.charAt(index)));
            if (index != secondNumber.length() - 1){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        ListNode result = mergeTwoLists(firstHead, secondHead);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

    }
}
