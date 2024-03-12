package LeetCode._1_链表.双指针_快慢指针._7_两个链表是否相交;

import LeetCode.Base.ListNode;

/*
* https://leetcode.cn/problems/3u1WK4/?show=1
*
* */
public class 剑指Offer_II_023_两个链表的第一个重合节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
