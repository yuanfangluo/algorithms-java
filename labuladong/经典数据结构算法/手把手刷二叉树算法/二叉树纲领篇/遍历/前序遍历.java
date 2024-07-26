package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉树纲领篇.遍历;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

public class 前序遍历 {
    List<Integer> res = new LinkedList<>();

    // 思路一：遍历一遍二叉树
    List<Integer> preorderTraverse1(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    // 思路二：分解问题
    List<Integer> preorderTraverse2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse2(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse2(root.right));
        return res;
    }
}
