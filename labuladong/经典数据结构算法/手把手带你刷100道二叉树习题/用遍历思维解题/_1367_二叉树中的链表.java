package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.ListNode;
import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/linked-list-in-binary-tree/
public class _1367_二叉树中的链表 {
    // 本质上，isSubPath 就是在遍历二叉树的所有节点，对每个节点用 check 函数判断是否能够将链表嵌进去。
    public boolean isSubPath(ListNode head, TreeNode root) {
        // base case
        if (head == null) return true;
        if (root == null) return false;
        // 当找到一个二叉树节点的值等于链表头结点时
        if (head.val == root.val) {
            // 判断是否能把链表嵌进去
            if (check(head, root)) {
                return true;
            }
        }
        // 继续去遍历其他节点尝试嵌入链表
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // 检查是否能够将链表嵌入二叉树
    boolean check(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val) {
            // 在子树上嵌入子链表
            return check(head.next, root.left) || check(head.next, root.right);
        }

        return false;
    }

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if(head == null) return true;
            if(root == null) return false;
            return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    
        public boolean isSub(ListNode head, TreeNode root){
            // 链表递归完了说明都匹配返回true
            if(head == null) return true;
            // 链表没递归完但是树完了说明不匹配返回false
            if(root == null) return false;
            // root code
            if(head.val != root.val) return false;
            // 递归逻辑
            return isSub(head.next, root.left) || isSub(head.next, root.right);
        }
    }
}
