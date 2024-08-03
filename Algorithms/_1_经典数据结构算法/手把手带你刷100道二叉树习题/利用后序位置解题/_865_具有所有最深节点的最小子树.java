package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
public class _865_具有所有最深节点的最小子树 {
    // 这道题就是让你求那些「最深」的叶子节点的最近公共祖先，可以看下前文 二叉树最近公共祖先。
    // 它需要知道自己的左右子树的最大深度：
    // 如果左右子树一样深，那么当前节点就是最近公共祖先；
    // 如果左右子树不一样深，那么最深叶子节点的最近公共祖先肯定在左右子树上。

    // 所以我们新建一个 Result 类，存放左右子树的最大深度及叶子节点的最近公共祖先节点，其余逻辑类似 104. 二叉树的最大深度。
    class Solution {
        class Result {
            public TreeNode node;
            public int depth;

            public Result(TreeNode node, int depth) {
                // 记录最近公共祖先节点 node
                this.node = node;
                // 记录以 node 为根的二叉树最大深度
                this.depth = depth;
            }
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            Result res = maxDepth(root);
            return res.node;
        }

        // 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
        Result maxDepth(TreeNode root) {
            if (root == null) {
                return new Result(null, 0);
            }

            Result left = maxDepth(root.left);
            Result right = maxDepth(root.right);

            if (left.depth == right.depth) {
                // 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
                // 以当前 root 节点为根的子树深度是子树深度 + 1
                return new Result(root, left.depth + 1);
            }

            // 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
            Result res = left.depth > right.depth ? left : right;
            
            // 正确维护二叉树的最大深度
            res.depth++;

            return res;
        }
    }
}
