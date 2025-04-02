// https://leetcode.cn/problems/remove-linked-list-elements/

import labuladong.Base.ListNode;

public class _203_移除链表元素 {
    class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }

    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}
