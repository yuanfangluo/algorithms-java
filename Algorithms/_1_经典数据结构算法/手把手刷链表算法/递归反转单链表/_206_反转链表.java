package Algorithms._1_经典数据结构算法.手把手刷链表算法.递归反转单链表;

import Algorithms.Base.ListNode;

/*
* https://leetcode.cn/problems/reverse-linked-list/description/
*
* */
public class _206_反转链表 {
    // 思路一：迭代
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 思路二：递归，最重要的就是明确递归函数的定义
    // 定义：输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
    ListNode reverseList2(ListNode head) {
        // 递归函数要有 base case
        // 意思是如果链表为空或者只有一个节点的时候，反转结果就是它自己，直接返回即可
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode reverseList22(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList22(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
