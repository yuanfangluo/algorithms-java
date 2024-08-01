package Algorithms.经典数据结构算法.手把手刷二叉树算法.二叉搜索树基操篇.判断BST的合法性;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/description/
public class _98_验证二叉搜索树 {
    // 方法一：
    boolean isValidBST1(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null)
            return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    // 方法二：
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> mins = new LinkedList<>();
        Queue<Integer> maxs = new LinkedList<>();

        nodes.offer(root);
        mins.offer(null);
        maxs.offer(null);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer min = mins.poll();
            Integer max = maxs.poll();

            if (min != null && node.val <= min)
                return false;
            if (max != null && node.val >= max)
                return false;
            if (node.left != null) {
                nodes.offer(node.left);
                mins.offer(min);
                maxs.offer(node.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                mins.offer(node.val);
                maxs.offer(max);
            }
        }
        return true;
    }
}
