package labuladong.LinkedList;

import labuladong.Base.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
public class _82_删除排序链表中的重复元素_II {
    /**
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 使用虚拟头节点
        ListNode dummy = new ListNode(-1);
        // 当前指针
        ListNode p = dummy;
        // 传入节点
        ListNode q = head;
        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                // 跳过重复节点
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                if (q == null) {
                    p.next = null;
                }
            } else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }

        return dummy.next;
    }

    // 递归方法
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public ListNode deleteDuplicates2(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates2(head.next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates2(head.next);
    }
}
