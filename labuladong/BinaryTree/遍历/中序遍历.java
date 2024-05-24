package labuladong.BinaryTree.遍历;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

public class 中序遍历 {
    List<Integer> res = new LinkedList<>();

    // 思路一：遍历一遍二叉树
    List<Integer> inorderTraverse1(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        res.add(root.val);

        traverse(root.right);
    }

    // 思路二：分解问题
    List<Integer> inorderTraverse2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(inorderTraverse2(root.left));

        res.add(root.val);

        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(inorderTraverse2(root.right));
        return res;
    }
}
