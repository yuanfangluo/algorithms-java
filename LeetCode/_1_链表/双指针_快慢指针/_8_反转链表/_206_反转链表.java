package LeetCode._1_链表.双指针_快慢指针._8_反转链表;

import LeetCode.Base.ListNode;

/*
* https://leetcode.cn/problems/reverse-linked-list/description/
*
* */
public class _206_反转链表 {
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
}
