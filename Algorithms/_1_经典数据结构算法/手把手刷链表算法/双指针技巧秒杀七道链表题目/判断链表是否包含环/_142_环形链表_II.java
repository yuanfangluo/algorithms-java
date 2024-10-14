package Algorithms._1_经典数据结构算法.手把手刷链表算法.双指针技巧秒杀七道链表题目.判断链表是否包含环;

import Algorithms.Base.ListNode;

/*
* https://leetcode.cn/problems/linked-list-cycle-ii/
*
* */
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

    class Solution2 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }

            if (fast == null || fast.next == null) {
                return null;
            }
            // 只要我们把快慢指针中的任一个重新指向 head，然后两个指针同速前进，k - m 步后一定会相遇，相遇之处就是环的起点了
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;

        }
    }
}
