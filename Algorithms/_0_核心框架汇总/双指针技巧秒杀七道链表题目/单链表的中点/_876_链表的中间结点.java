package Algorithms._0_核心框架汇总.双指针技巧秒杀七道链表题目.单链表的中点;

import Algorithms.Base.ListNode;

// https://leetcode.cn/problems/middle-of-the-linked-list/
public class _876_链表的中间结点 {
    class Solution {
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
    }
}
