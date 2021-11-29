package leetCode;

import ann.FinishAnno;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Problem_02_add_two_number
 * @Description LeetCode第二题：两数相加
 * @Author Hongyang Gu
 * @Date 2021/10/27 3:07 下午
 */
@FinishAnno
public class Problem_02_AddTwoNumber {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     *
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
     // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
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
        int[] second = new int[]{0};
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

        ListNode listNode = toNumbersAdd(firstHead, secondHead);
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode toNumbersAdd(ListNode firstNumber, ListNode secondNumber) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        ListNode resHead = new ListNode();
        ListNode temp = resHead;
        ListNode preTemp = temp;
        while (firstNumber != null) {
            first.add(String.valueOf(firstNumber.val));
            firstNumber = firstNumber.next;
        }
        while (secondNumber != null) {
            second.add(String.valueOf(secondNumber.val));
            secondNumber = secondNumber.next;
        }
        int forNumber = Math.min(first.size(), second.size());
        for (int i = 0; i < forNumber; i++) {
            int number = temp.val + Integer.parseInt(first.get(i)) + Integer.parseInt(second.get(i));
            temp.val = number % 10;
            if (number / 10 > 0){
                temp.next = new ListNode(number / 10);
            } else {
                temp.next = new ListNode();
            }
            preTemp = temp;
            temp = temp.next;
        }
        if (first.size() > forNumber) {
            for (int i = forNumber; i < first.size(); i++) {
                int number = temp.val + Integer.parseInt(first.get(i));
                temp.val = number % 10;
                if (number / 10 > 0){
                    temp.next = new ListNode(number / 10);
                } else {
                    temp.next = new ListNode();
                }
                preTemp = temp;
                temp = temp.next;
            }
        }

        if (second.size() > forNumber) {
            for (int i = forNumber; i < second.size(); i++) {
                int number = temp.val + Integer.parseInt(second.get(i));
                temp.val = number % 10;
                if (number / 10 > 0){
                    temp.next = new ListNode(number / 10);
                } else {
                    temp.next = new ListNode();
                }
                preTemp = temp;
                temp = temp.next;
            }
        }
        if (preTemp.next.val == 0){
            preTemp.next = null;
        }
        return resHead;
    }
    /**
     * 思路1：
     *  将两个链表进行遍历，分别放入
     */
}