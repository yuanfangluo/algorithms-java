package Algorithms._0_核心框架汇总.二叉树.两种解题思路;

import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {
    // 遍历思路
    class Solution1 {
        List<Integer> res = new LinkedList<>();

        // 返回前序遍历结果
        List<Integer> preorderTraverse(TreeNode root) {
            traverse(root);
            return res;
        }

        // 二叉树遍历函数
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            // 前序位置
            res.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }

    // 分解问题思路
    class Solution2 {
        // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
        List<Integer> preorderTraverse(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            // 前序遍历的结果，root.val 在第一个
            res.add(root.val);
            // 利用函数定义，后面接着左子树的前序遍历结果
            res.addAll(preorderTraverse(root.left));
            // 利用函数定义，最后接着右子树的前序遍历结果
            res.addAll(preorderTraverse(root.right));
            return res;
        }
    }

}
