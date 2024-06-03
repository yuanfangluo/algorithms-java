package labuladong.LinkedList.反转链表;

import labuladong.Base.ListNode;

/*
* https://leetcode.cn/problems/reverse-linked-list/description/
*
* */
public class _206_反转链表 {
    // 思路一：迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 思路二：递归
    // 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
