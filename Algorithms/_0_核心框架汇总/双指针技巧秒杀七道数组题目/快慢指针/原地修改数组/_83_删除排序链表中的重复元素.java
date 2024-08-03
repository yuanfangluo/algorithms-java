package Algorithms._0_核心框架汇总.双指针技巧秒杀七道数组题目.快慢指针.原地修改数组;

import Algorithms.Base.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
public class _83_删除排序链表中的重复元素 {
    class Solution {
        ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    // nums[slow] = nums[fast];
                    slow.next = fast;
                    // slow++;
                    slow = slow.next;
                }
                // fast++
                fast = fast.next;
            }
            // 断开与后面重复元素的连接
            slow.next = null;
            return head;
        }
    }
}
