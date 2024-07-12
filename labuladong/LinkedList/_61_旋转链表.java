package labuladong.LinkedList;

import labuladong.Base.ListNode;

// https://leetcode.cn/problems/rotate-list/description/
public class _61_旋转链表 {

    // 你只需要先将整个链表反转，然后将前 k 个节点和后 n - k 个节点分别反转，就得到了结果。
    public ListNode rotateRight(ListNode head, int k) {
        // 先求出链表的长度
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }

        // 再对k求模运算
        k = k % n;

        // 先将整个链表反转
        ListNode newHead = reverseList(head);
        
        return null;
    }

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
