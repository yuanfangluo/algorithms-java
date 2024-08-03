package Algorithms._1_经典数据结构算法.手把手刷链表算法.递归反转单链表;

import Algorithms.Base.ListNode;

public class 反转链表前N个节点 {
    ListNode successor = null; // 后驱节点
    // 将链表的前 n 个节点反转（n <= 链表长度）
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;

    }

    ListNode reverseN11(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN11(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverseN22(ListNode head, int n) {
        if (n == 1) {
            return head;
        }

        ListNode last = reverseN22(head.next, n - 1);
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;
        return last;
    }


}
