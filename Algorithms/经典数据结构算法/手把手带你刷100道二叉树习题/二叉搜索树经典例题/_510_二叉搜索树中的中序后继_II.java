package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

// https://leetcode.cn/problems/inorder-successor-in-bst-ii/
public class _510_二叉搜索树中的中序后继_II {

    // 对于一个 BST 节点 node，比它大的那个 successor 会在哪里呢？
    // 首先，肯定要去 node 的右子树去找，右子树的最小值就是它的 successor。
    // 但如果右子树为空，是不是就意味着 node 就是没有 successor，也就是说 node 是 BST 中最大的那个节点？
    // 显然不是，除了右子树，successor 还可能出现在父节点，这就是本题给出 parent 指针的原因，方便你向上遍历父节点。
    // 但并不是直接相连的父节点就是 successor
    // 必须是右上方的父节点才是 successor

    class Solution {
        class Node {
            public int val;
            public Node left;
            public Node right;
            public Node parent;
        };

        public Node inorderSuccessor(Node node) {
            // 右子树的最小值就是 successor
            Node p = node.right;

            while (p != null && p.left != null) {
                p = p.left;
            }

            if (p != null) {
                return p;
            }

            // 没有右子树的话，第一个比自己大的父节点就是 successor。
            p = node;

            while (p.parent != null && p.parent.right == p) {
                p = p.parent;
            }

            return p.parent;
        }
    }
}
