package labuladong.手把手刷数据结构.链表.双指针技巧秒杀七道链表题目.单链表的中点;

import labuladong.Base.ListNode;

/*
* https://leetcode.cn/problems/middle-of-the-linked-list/
*
* */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;

    }

}
