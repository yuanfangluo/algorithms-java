package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/
public class _987_二叉树的垂序遍历 {

    // 记录每个节点和对应的坐标 (row, col)
    class Triple {
        public int row, col;
        public TreeNode node;

        public Triple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    ArrayList<Triple> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 遍历二叉树，并且为所有节点生成对应的坐标
        traverse(root, 0, 0);
        // 根据题意，根据坐标值对所有节点进行排序：
        // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
        // 如果 col 和 row 都相同，按照 node.val 从小到大排序。

        Collections.sort(nodes, (Triple a, Triple b) -> {
            if (a.col == b.col && a.row == b.row) {
                return a.node.val - b.node.val;
            }
            if (a.col == b.col) {
                return a.row - b.row;
            }
            return a.col - b.col;
        });

        // 将排好序的节点组装成题目要求的返回格式
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 记录上一列编号，初始化一个特殊值
        int preCol = Integer.MIN_VALUE;

        for (int i = 0; i < nodes.size(); i++) {
            Triple cur = nodes.get(i);
            if (cur.col != preCol) {
                // 开始记录新的一列
                res.addLast(new LinkedList<>());
                preCol = cur.col;
            }
            res.getLast().add(cur.node.val);
        }

        return res;
    }

    // 如果整棵树的根节点坐标是[0, 0]，如何打印其他节点的坐标？
    void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        // int[] p = new int[] { row, col };
        // System.out.println(p.toString());

        nodes.add(new Triple(root, row, col));

        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }

}
