package LeetCode._1_链表.扩展;

import LeetCode.Base.ListNode;
import LeetCode.Base.TreeNode;

/*
* https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/?show=1
*
* */
public class _109_有序链表转换二叉搜索树 {

    /* 解法三、通过中序遍历特点写出的解法 */
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }

        cur = head;
        return inorderBuild(0, len - 1);
    }

    ListNode cur;

    TreeNode inorderBuild(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        // 构造左子树
        TreeNode leftTree = inorderBuild(left, mid - 1);
        // 构造根节点
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        // 构造右子树
        TreeNode rightTree = inorderBuild(mid + 1, right);
        // 将左右子树接到根节点上
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }


    /* 解法二、通过找链表中点的方式写出的解法 */
    public TreeNode sortedListToBST_2(ListNode head) {
        return build(head, null);
    }

    // 把链表左闭右开区间 [begin, end) 的节点构造成 BST
    TreeNode build(ListNode begin, ListNode end) {
        if (begin == end) {
            // 因为是左闭右开区间，所以现在已经成空集了
            return null;
        }
        ListNode mid = getMid(begin, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(begin, mid);
        root.right = build(mid.next, end);
        return root;
    }

    // 获取链表左闭右开区间 [begin, end) 的中心节点
    ListNode getMid(ListNode begin, ListNode end) {
        ListNode slow = begin, fast = begin;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
