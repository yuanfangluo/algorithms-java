package labuladong._0_核心框架汇总.双指针技巧秒杀七道链表题目.判断链表是否包含环;

import labuladong.Base.ListNode;

// https://leetcode.cn/problems/linked-list-cycle-ii/
public class _142_环形链表_II {
    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast, slow;
            fast = slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                    break;
            }
            // 上面的代码类似 hasCycle 函数
            if (fast == null || fast.next == null) {
                // fast 遇到空指针说明没有环
                return null;
            }

            // 到这里代表有环
            // 将慢指针重新指向头结点
            slow = head;
            // 快慢指针同步前进，相交点就是环起点
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
