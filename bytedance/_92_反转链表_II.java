import Algorithms.Base.ListNode;
// https://leetcode.cn/problems/reverse-linked-list-ii/
public class _92_反转链表_II {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // base case
            // 如果 m == 1，就相当于反转链表开头的 n 个元素
            if (left == 1) {
                return reverseN(head, right);
            }

            // 前进到反转的起点触发 base case
            // 以head.next 为起点，反转 left -1 到 right -1 个节点
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        ListNode reverseList(ListNode head) {
            // 递归函数要有 base case
            // 意思是如果链表为空或者只有一个节点的时候，反转结果就是它自己，直接返回即可
            if (head == null || head.next == null) {
                return head;
            }

            // 递归调用
            // 先反转后面的节点 head.next 为 newHead
            // 再将 head 节点和 newHead 节点连起来
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }


        ListNode successor = null; // 后驱节点

        // 将链表的前 n 个节点反转（n <= 链表长度，反转以 head 为起点的 n 个节点，返回新的头结点
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
    }
}