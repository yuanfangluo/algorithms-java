package labuladong._1_经典数据结构算法.手把手刷二叉树算法.二叉搜索树构造篇;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/unique-binary-search-trees-ii/
public class _95_不同的二叉搜索树_II {

    // 1 <= n <= 8
    public List<TreeNode> generateTrees(int n) {
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
            // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
            // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
            // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
            res.add(null);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有有效 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
