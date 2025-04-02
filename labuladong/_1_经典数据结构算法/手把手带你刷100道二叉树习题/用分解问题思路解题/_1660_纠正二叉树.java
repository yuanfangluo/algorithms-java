package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.HashSet;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/correct-a-binary-tree/
public class _1660_纠正二叉树 {
    // 如何知道一个节点 x 是「错误」节点？
    // 需要要知道它的右子节点错误地指向同层右侧的一另一个节点。

    // 那么如何让节点 x 知道自己错指了呢？
    // 如果用层序遍历的方式应该比较容易想到解法，我们可以从右向左遍历每一行的节点并记录下来访问过的节点，如果你发现某个节点 x
    // 的右子节点已经被访问过，那么这个节点 x 就是错误节点。

    // 如果用递归遍历的方式，如何做到「从右向左」遍历每一行的节点呢？
    // 只要稍微改一下二叉树的遍历框架，先遍历右子树后遍历左子树，这样就是先遍历右侧节点后遍历左侧节点，也就相当于从右向左遍历了。

    // 同理，遍历的时候我们同时记录已遍历的节点。这样 x 如果发现自己的右子节点已经被访问了，就说明 x 节点是「错误」的。

    // 记录已访问过的节点
    HashSet<TreeNode> visited = new HashSet<>();

    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先遍历右子树
        if (root.right != null && visited.contains(root.right)) {
            // 找到「无效节点」，删除整棵子树
            return null;
        }
        // 记录已访问过的节点
        visited.add(root);
        // 要先遍历右子树，后遍历左子树
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }

}
