package LeetCode._1_链表.双指针_快慢指针._8_反转链表;

import LeetCode.Base.ListNode;

public class 反转链表 {

    ListNode reverse(ListNode head) {
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

