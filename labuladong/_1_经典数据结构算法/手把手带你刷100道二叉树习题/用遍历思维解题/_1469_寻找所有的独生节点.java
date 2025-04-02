package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-all-the-lonely-nodes/
public class _1469_寻找所有的独生节点 {
    
    List<Integer> res = new LinkedList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 发现独生节点
        if (root.left == null && root.right != null) {
            res.add(root.right.val);
        }

        if (root.left != null && root.right == null) {
            res.add(root.left.val);
        }

        traverse(root.left);
        traverse(root.right);
    }
}
