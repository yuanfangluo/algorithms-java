package labuladong._0_核心框架汇总.算法的本质.二叉树;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

public class 二叉树的前序遍历 {
    // 思路一：遍历一遍二叉树得到结果
    class Solution {
        List<Integer> res = new LinkedList<>();

        // 返回前序遍历结果
        List<Integer> preorder(TreeNode root) {
            traverse(root);
            return res;
        }

        // 二叉树遍历函数
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            // 前序遍历位置
            res.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }

    // 思路二：分解问题思路
    class Solution2 {
        // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
        List<Integer> preorder(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            // 前序遍历的结果，root.val 在第一个
            res.add(root.val);
            // 后面接着左子树的前序遍历结果
            res.addAll(preorder(root.left));
            // 最后接着右子树的前序遍历结果
            res.addAll(preorder(root.right));
            return res;
        }
    }
}
