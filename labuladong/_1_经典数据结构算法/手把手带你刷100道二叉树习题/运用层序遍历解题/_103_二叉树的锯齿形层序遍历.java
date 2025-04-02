package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

import java.util.List;

// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class _103_二叉树的锯齿形层序遍历 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // 用一个 flag 来记录当前层是从左到右还是从右到左遍历
            // 从左到右遍历的话，就把当前层的节点值放入 level 中
            // 从右到左遍历的话，就把当前层的节点值倒序放入 level 中
            // 当遍历完一层后，把 flag 取反，再遍历下一层
            // 这样就可以实现锯齿形遍历了
            // 从左到右遍历的话，flag 为 true
            // 从右到左遍历的话，flag 为 false
            boolean flag = true;
            while (!q.isEmpty()) {
                int sz = q.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                if (!flag) {
                    Collections.reverse(level);
                }
                flag = !flag;
                res.add(level);
            }
            return res;
        }
    }

    class Solution2 {
        List<List<Integer>> ans;
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);
            return ans;
        }

        public void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (ans.size() == depth) {
                ans.add(new ArrayList<>());
            }
            if (depth % 2 == 0) {
                ans.get(depth).add(root.val);
            } else {
                ans.get(depth).add(0, root.val);
            }

            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
