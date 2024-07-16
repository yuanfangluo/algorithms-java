package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.用分解问题思路解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/maximum-binary-tree-ii/
public class _998_最大二叉树_II {
    // 新增的 val 是添加在原始数组的最后的，根据构建最大二叉树的逻辑，正常来说最后的这个值一定是在右子树的，
    // 可以对右子树递归调用 insertIntoMaxTree 插入进去。

    // 但是一种特殊情况是 val 比原始数组中的所有元素都大，那么根据构建最大二叉树的逻辑，原来的这棵树应该成为 val 节点的左子树。

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
        } else {
            // 如果 val 不是最大的，那么就应该在右子树上，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            root.right = insertIntoMaxTree(root.right, val);
        }
        
        return root;
    }
}
