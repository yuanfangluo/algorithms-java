package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.利用后序位置解题;

import java.util.ArrayList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-leaves-of-binary-tree/
public class _366_寻找二叉树的叶子节点 {
    // 我们正常说的二叉树高度都是从上到下，从根节点到叶子结点递增的，
    // 而这题可以需要思考，把二叉树的高度理解成从叶子节点到根节点从下到上递增的，
    // 那么把相同高度的节点分到一起就是题目想要的答案。
    // 那么我们可以定义一个递归函数 maxDepth，输入一个节点 root，返回以 root 为根的树的最大深度。
    // 然后，我们在 maxDepth 函数的后序遍历位置就可以获取当前节点距离叶子节点的高度。
    class Solution {
        ArrayList<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            maxDepth(root);
            return res;
        }

        // 定义：输入节点 root，返回以 root 为根的树的最大深度
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // 当前节点距离叶子节点的高度（最大深度）
            int h = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

            // 后序遍历位置
            if (res.size() < h) {
                res.add(new ArrayList<>());
            }

            // 把所有相同高度的叶子节点放在一起
            res.get(h - 1).add(root.val);

            return h;
        }
    }
}
