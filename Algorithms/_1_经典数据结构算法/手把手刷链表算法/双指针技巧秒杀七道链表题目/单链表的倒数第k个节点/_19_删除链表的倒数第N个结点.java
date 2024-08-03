package Algorithms._1_经典数据结构算法.手把手刷链表算法.双指针技巧秒杀七道链表题目.单链表的倒数第k个节点;

import Algorithms.Base.ListNode;

/*
* https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
*
* */
public class _19_删除链表的倒数第N个结点 {

    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        // 我们又使用了虚拟头结点的技巧，也是为了防止出现空指针的情况，
        // 比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，
        // 那按照算法逻辑，应该首先找到倒数第 6 个节点。但第一个节点前面已经没有节点了，这就会出错。
        // 但有了我们虚拟节点 dummy 的存在，就避免了这个问题，能够对这种情况进行正确的删除

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode x = findFromEnd(dummy, n + 1);

        x.next = x.next.next;

        return dummy.next;
    }


    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
