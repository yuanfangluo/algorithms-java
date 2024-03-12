package LeetCode.LinkedList;

import LeetCode.Base.ListNode;

public class LinkedList {
    public static void main(String[] args) {
        System.out.println("LinkedList");
    }

    // 迭代
    void traverse1(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // 递归
    void traverse(ListNode node) {
        if (node == null) {
            return;
        }
        traverse(node.next);
    }
}
