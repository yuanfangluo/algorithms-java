package Algorithms.经典数据结构算法.手把手刷链表算法.回文链表;

import java.util.LinkedList;

import Algorithms.Base.ListNode;

/*
* https://leetcode.cn/problems/palindrome-linked-list/?show=1
*
* */
public class _234_回文链表 {

    // 思路一：通过反转链表
    // 把原始链表反转存入一条新的链表，然后比较这两条链表是否相同
    // 算法总体的时间复杂度 O(N)，空间复杂度 O(1)，已经是最优的了。
    // 这种解法虽然高效，但破坏了输入链表的原始结构，能不能避免这个瑕疵呢？
    // 其实这个问题很好解决，关键在于得到p, q这两个指针位置
    // 这样，只要在函数 return 之前加一段代码即可恢复原先链表顺序：

    // 总结：
    // 寻找回文串是从中间向两端扩展，判断回文串是从两端向中间收缩。
    // 对于单链表，无法直接倒序遍历，可以造一条新的反转链表，可以利用链表的后序遍历，也可以用栈结构倒序处理单链表。
    // 具体到回文链表的判断问题，由于回文的特殊性，可以不完全反转链表，而是仅仅反转部分链表，将空间复杂度降到 O(1)。
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
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
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
