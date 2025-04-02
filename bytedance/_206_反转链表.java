import labuladong.Base.ListNode;
// https://leetcode.cn/problems/reverse-linked-list/
public class _206_反转链表 {
    // 思路一：迭代
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    // 思路二：递归
    class Solution2 {
        // 最重要的就是明确递归函数的定义
        // 定义：输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
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
    }
}
