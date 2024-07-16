package labuladong.手把手刷数据结构.手把手刷链表算法.双指针技巧秒杀七道链表题目.合并k个有序链表;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.naming.LimitExceededException;

import labuladong.Base.ListNode;

/*
* https://leetcode.cn/problems/merge-k-sorted-lists/
*
* */
public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();

        ListNode p = dummy;
        // 最小堆
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next; 
            // p.next = null; // 这里没有置为空是因为后面会重新修改，最终都是置为空
        }

        return dummy.next;
    }

    // 时间复杂度：
    // 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；
    // 所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。

}
