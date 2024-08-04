package Algorithms.核心框架汇总.双指针技巧秒杀七道链表题目.单链表的分解;

import Algorithms.Base.ListNode;

// https://leetcode.cn/problems/partition-list/
public class _86_分隔链表 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 存放小于 x 的链表的虚拟头结点
            ListNode dummy1 = new ListNode(-1);
            // 存放大于等于 x 的链表的虚拟头结点
            ListNode dummy2 = new ListNode(-1);
            // p1, p2 指针负责生成结果链表
            ListNode p1 = dummy1, p2 = dummy2;
            // p 负责遍历原链表，类似合并两个有序链表的逻辑
            // 这里是将一个链表分解成两个链表
            ListNode p = head;
            while (p != null) {
                if (p.val >= x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                // 断开原链表中的每个节点的 next 指针
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            // 链接两个链表
            p1.next = dummy2.next;

            return dummy1.next;
        }
    }
}
