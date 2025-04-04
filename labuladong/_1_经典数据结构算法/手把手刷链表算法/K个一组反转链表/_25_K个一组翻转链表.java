package labuladong._1_经典数据结构算法.手把手刷链表算法.K个一组反转链表;

import labuladong.Base.ListNode;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
public class _25_K个一组翻转链表 {
    // 整体思路：
    // 1、先反转以 head 开头的 k 个元素。
    // 2、将第 k + 1 个元素作为 head 递归调用 reverseKGroup 函数。
    // 3、将上述两个过程的结果连接起来。
    class Solution {
        // 反转以 a 为头结点的链表
        ListNode reverse(ListNode a) {
            ListNode pre = null, cur = a;
            while (cur != null) {
                ListNode nxt = cur.next;
                // 逐个结点反转
                cur.next = pre;
                // 更新指针位置
                pre = cur;
                cur = nxt;
            }
            // 返回反转后的头结点
            return pre;
        }

        /** 反转区间 [a, b) 的元素，注意是左闭右开 */
        ListNode reverse(ListNode a, ListNode b) {
            ListNode pre = null, cur = a;
            // while 终止的条件改一下就行了
            while (cur != b) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 返回反转后的头结点
            return pre;
        }

        // 定义：反转以 head 为头结点的 k 个元素，返回新的头结点
        ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (b == null) {
                    return head;
                }
                b = b.next;
            }

            // 反转前 k 个元素
            ListNode newHead = reverse(a, b);

            // 递归反转后续链表并连接起来
            // 此时 a 为最后一个节点
            // a.next 为下一个待反转的子链表的头结点
            a.next = reverseKGroup(b, k);

            return newHead;
        }
    }
}
