package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/
public class _1080_根到叶路径上的不足节点 {

    class Solution {

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            boolean haveSufficient = checkSufficientLeaf(root, 0, limit);
            return haveSufficient ? root : null;
        }

        // 定义：输入一个节点 node，和从根节点到 node 的路径上的节点值之和 sum，
        public boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
            if (node == null) {
                return false;
            }

            if (node.left == null && node.right == null) {
                return node.val + sum >= limit;
            }

            boolean haveSufficientLeft = checkSufficientLeaf(node.left, sum + node.val, limit);
            boolean haveSufficientRight = checkSufficientLeaf(node.right, sum + node.val, limit);

            if (!haveSufficientLeft) {
                node.left = null;
            }

            if (!haveSufficientRight) {
                node.right = null;
            }

            return haveSufficientLeft || haveSufficientRight;
        }
    }

    // 首先，对于一个叶子节点，它本身就是以自己为根的这棵二叉树的路径，
    // 那么这条路径是否小于 limit 的约束是很显然的，如果小于 limit，说明它需要被删除。

    // 然后，对于一个非叶子节点 x，它是否是一个「不足节点」，
    // 或者说是否存在一条不满足 limit 约束的路径穿过这个节点，其实可以根据子树推导出来。

    // 如果 x 的左右子节点都被删除，那么就说明 x 的左右子树上的路径都不满足 limit 的约束，
    // 也就是说所有穿过 x 的路径都不满足约束，即 x 也应该被删除。

    class Solution2 {

        // 定义：输入一个节点 root，和约束 limit，
        // 删除以 root 为根的二叉树中的「不足节点」，返回删除完成后的二叉树根节点
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) {
                return null;
            }

            // 前序位置，接收父节点传递的 limit 约束决定叶子结点是否需要被删除
            if (root.left == null && root.right == null) {
                if (root.val < limit) {
                    // 对于叶子节点，如果低于 limit 说明需要被删除
                    return null;
                }
                return root;
            }

            // 先对左右子树进行删除，接收返回值
            TreeNode left = sufficientSubset(root.left, limit - root.val);
            TreeNode right = sufficientSubset(root.right, limit - root.val);

            // 后序位置，根据子树的删除情况决定自己是否需要被删除
            if (left == null && right == null) {
                // 如果左右子树不满足 limit - root.val 的约束，那么就存在经过 root
                // 节点的路径不满足约束，也就说明 root 节点是「不足节点」，需要被删掉
                return null;
            }
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
