package Algorithms._1_经典数据结构算法.手把手设计数据结构.栈的经典习题;

import java.util.Stack;

import Algorithms.Base.ListNode;

// https://leetcode.cn/problems/reorder-list/
public class _143_重排链表 {
    class Solution {
        public void reorderList(ListNode head) {
            Stack<ListNode> stk = new Stack<>();
            // 先把所有节点装进栈里，得到倒序结果
            ListNode p = head;
            while (p != null) {
                stk.push(p);
                p = p.next;
            }

            p = head;
            while (p != null) {
                // 链表尾部的节点
                ListNode lastNode = stk.pop();
                ListNode next = p.next;
                if (lastNode == next || lastNode.next == next) {
                    // 结束条件，链表节点数为奇数或偶数时均适用
                    lastNode.next = null;
                    break;
                }
                p.next = lastNode;
                lastNode.next = next;
                p = next;
            }
        }
    }
}
