package labuladong.LinkedList.回文链表;

import java.util.LinkedList;

import labuladong.Base.ListNode;

/*
* https://leetcode.cn/problems/palindrome-linked-list/?show=1
*
* */
public class _234_回文链表 {

    // 思路一：通过反转链表
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 思路二：通过二叉树的遍历
    // 实际上就是把链表节点放入一个栈，然后再拿出来，这时候元素顺序就是反的，只不过我们利用的是递归函数的堆栈而已

    // 左侧指针
    ListNode left;

    boolean isPalindrome2(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null)
            return true;
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    // 用快慢指针求中间节点，同时用栈保存慢指针的轨迹，然后验证链表后半部分和出栈序列的一致性

     public boolean isPalindrome3(ListNode head) {
        LinkedList<ListNode> st = new LinkedList<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            st.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 链表长度是奇数，slow在中间，再往前走一次
        if (fast != null && !st.isEmpty()) {
            slow = slow.next;
        } 

        while (!st.isEmpty()) {
            ListNode cur = st.pop();
            if (cur.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

}
