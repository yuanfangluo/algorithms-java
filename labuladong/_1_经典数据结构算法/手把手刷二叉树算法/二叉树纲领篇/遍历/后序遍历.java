package labuladong._1_经典数据结构算法.手把手刷二叉树算法.二叉树纲领篇.遍历;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

public class 后序遍历 {
    List<Integer> res = new LinkedList<>();

    // 思路一：遍历一遍二叉树
    List<Integer> postorderTraverse1(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }

    // 思路二：分解问题
    List<Integer> postorderTraverse2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(postorderTraverse2(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(postorderTraverse2(root.right));
        res.add(root.val);
        return res;
    }
}
