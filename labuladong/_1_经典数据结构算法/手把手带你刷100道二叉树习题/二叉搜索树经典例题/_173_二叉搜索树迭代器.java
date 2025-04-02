package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-search-tree-iterator/
public class _173_二叉搜索树迭代器 {
    class BSTIterator1 {

        List<Integer> list = new ArrayList<>();

        int i = 0;

        public BSTIterator1(TreeNode root) {
            dfs(root);
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        public int next() {
            return list.get(i++);
        }

        public boolean hasNext() {
            return i < list.size();
        }
    }

    // 利用栈模拟递归对 BST 进行中序遍历可以认为是一种套路题型，你记住就好了，
    // 关键在于理解 pushLeftBranch 函数，深刻理解二叉树递归遍历的过程：
    class BSTIterator2 {
        // 模拟递归栈
        private Stack<TreeNode> stk = new Stack<>();

        // 左侧树枝一撸到底]
        private void pushLeftBranch(TreeNode p) {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
        }

        public BSTIterator2(TreeNode root) {
            pushLeftBranch(root);
        }

        public int next() {
            TreeNode p = stk.pop();
            pushLeftBranch(p.right);
            return p.val;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
    }
}
