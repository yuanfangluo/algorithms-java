package labuladong.LinkedList;

import java.util.HashMap;
import java.util.Map;

import labuladong.Base.ListNode;

/*
* https://leetcode.cn/problems/remove-duplicates-from-an-unsorted-linked-list/?show=1
*
*
* */
public class _1836_从未排序的链表中移除重复元素 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        // 先遍历一遍链表，记录每个值出现的次数
        ListNode p = head;
        while (p != null) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        // 需要创建一个新的链表，使用虚拟头节点
        // 虚拟头结点（哨兵节点），存放结果链表
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 再遍历一遍节点，把重复出现的节点剔除
        p = dummy;
        while (p != null) {
            // unique 指针负责寻找不重复的节点
            ListNode unique = p.next;
            while (unique != null && count.get(unique.val) > 1) {
                // 跳过重复节点，直到找到不重复的节点
                unique = unique.next;
            }
            // 接入不重复的节点或尾部空指针
            p.next = unique;
            // p 前进，继续寻找不重复节点
            p = p.next;
        }
        return dummy.next;
    }
}
