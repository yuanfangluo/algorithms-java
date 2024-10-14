package Algorithms._0_核心框架汇总.学习算法和刷题的框架思维.框架;

import Algorithms.Base.ListNode;

// 兼具迭代和递归结构：
public class 链表遍历框架 {
    // 迭代
    class Solution1 {
        void traverse(ListNode head) {
            for (ListNode p = head; p != null; p = p.next) {
                // 迭代访问 p.val
            }
        }
    }

    // 递归
    class Solution2 {
        void traverse(ListNode head) {
            // 递归访问 head.val
            traverse(head.next);
        }
    }
}
