package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import java.util.HashSet;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/equal-tree-partition/
public class _663_均匀树划分 {
    // 这个问题看起来难，实际上只要换个思路就变简单了。
    // 如果我知道了整棵树所有节点之和 treeSum，那么如果存在一棵和为 treeSum / 2 的子树，就说明这棵二叉树是可以分解成两部分的。
    // 计算一棵树的所有节点之和，等于左右子树的节点之和加上根节点，同时在后序遍历的位置记录子树的和即可

    class Solution {
        HashSet<Integer> subTreeSum = new HashSet<>();

        public boolean checkEqualTree(TreeNode root) {
            // 不要直接输入 root，subTreeSum 中应该只存储子树的元素和，
            // 否则整棵树的元素和为 0 时会出问题
            // int treeSum = sum(root);
            int treeSum = root.val + sum(root.left) + sum(root.right);
            if ((treeSum & 1) != 0) { // treeSum不是偶数的时候
                // 不可能平分
                return false;
            }
            // 如果有子树的和为 treeSum / 2，说明可平分
            return subTreeSum.contains(treeSum / 2);
        }

        // 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
        int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            // 后序位置
            int rootSum = leftSum + rightSum + root.val;
            subTreeSum.add(rootSum);
            return rootSum;
        }
    }

    class Solution2 {
        TreeNode root;
        int sum = 0;
        boolean equal = false;

        public boolean checkEqualTree(TreeNode root) {
            this.root = root;
            this.sum = getSum(root, false);
            getSum(root, true);
            return equal;
        }

        public int getSum(TreeNode node, boolean findSubTree) {
            int curSum = node.val;
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                curSum += getSum(node.left, findSubTree);
            }
            if (right != null) {
                curSum += getSum(node.right, findSubTree);
            }
            // 结点的和可能为0 针对node != root
            if (findSubTree && node != root && curSum * 2 == sum) {
                equal = true;
            }
            return curSum;
        }
    }
}
