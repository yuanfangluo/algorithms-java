package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/
public class _1305_两棵二叉搜索树中的所有元素 {
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            // BST 有序迭代器
            BSTIterator t1 = new BSTIterator(root1);
            BSTIterator t2 = new BSTIterator(root2);
            LinkedList<Integer> res = new LinkedList<>();
            // 类似合并有序链表的算法逻辑
            while (t1.hasNext() && t2.hasNext()) {
                if (t1.peek() > t2.peek()) {
                    res.add(t2.next());
                } else {
                    res.add(t1.next());
                }
            }
            // 如果有一棵 BST 还剩元素，添加到最后
            while (t1.hasNext()) {
                res.add(t1.next());
            }
            while (t2.hasNext()) {
                res.add(t2.next());
            }
            return res;
        }

    }

    class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int i = 0;

        public BSTIterator(TreeNode root) {
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

        public int peek() {
            return list.get(i);
        }
    }
}
