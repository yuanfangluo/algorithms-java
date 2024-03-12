package LeetCode._1_链表.双指针_快慢指针._6_判断链表是否包含环;

import LeetCode.Base.ListNode;

/*
*
* https://leetcode.cn/problems/linked-list-cycle/
* */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
