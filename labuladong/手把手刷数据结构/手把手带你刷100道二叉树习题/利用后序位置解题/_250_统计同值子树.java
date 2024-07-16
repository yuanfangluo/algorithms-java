package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/count-univalue-subtrees/
public class _250_统计同值子树 {
    class Solution {
        public int countUnivalSubtrees(TreeNode root) {
            int[] res = new int[1];
            dfs(root, res);
            return res[0];
        }

        private boolean dfs(TreeNode root, int[] res) {
            if (root == null) {
                return true;
            }
            boolean left = dfs(root.left, res);
            boolean right = dfs(root.right, res);
            if (left && right) {
                if (root.left!= null && root.val!= root.left.val) {
                    return false;
                }
                if (root.right!= null && root.val!= root.right.val) {
                    return false;
                }
                res[0]++;
                return true;
            }
            return false;
        }
    }
}
