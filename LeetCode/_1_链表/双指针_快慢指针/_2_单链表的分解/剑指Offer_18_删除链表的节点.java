package LeetCode._1_链表.双指针_快慢指针._2_单链表的分解;

import LeetCode.Base.ListNode;

/*
* https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?show=1
*
* 你可以认为这道题是把原链表分解成「值为 val」和「值不为 val」的两条链表，就可以复用 86 题的思路了。
*
* */
public class 剑指Offer_18_删除链表的节点 {


    public ListNode deleteNode1(ListNode head, int val) {
        // 存放删除 val 的链表
        ListNode dummy = new ListNode(-1);
        // q 指针负责生成结果链表
        ListNode q = dummy;
        // p 负责遍历原链表
        ListNode p = head;
        while (p != null) {
            if (p.val != val) {
                // 把值不为 val 的节点接到结果链表上
                q.next = p;
                q = q.next;
            }
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        return dummy.next;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        // 存放删除 val 的链表
        ListNode dummy = new ListNode();
        dummy.next = head;
        // prev 指针负责生成结果链表
        ListNode prev = dummy;
        // cur 负责遍历原链表
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


}
