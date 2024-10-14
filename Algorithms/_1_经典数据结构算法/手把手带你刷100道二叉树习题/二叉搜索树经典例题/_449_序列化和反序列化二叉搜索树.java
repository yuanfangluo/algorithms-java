package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import java.util.LinkedList;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/serialize-and-deserialize-bst/
public class _449_序列化和反序列化二叉搜索树 {
    class Solution {
        // 分隔符，区分每个节点的值
        private final static String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            // 前序遍历位置进行序列化
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty())
                return null;
            // 转化成前序遍历结果
            LinkedList<Integer> inorder = new LinkedList<>();
            for (String s : data.split(SEP)) {
                inorder.offer(Integer.parseInt(s));
            }
            return deserialize(inorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        // 定义：将 nodes 中值在闭区间 [min, max] 的节点构造成一棵 BST
        private TreeNode deserialize(LinkedList<Integer> nodes, int min, int max) {
            if (nodes.isEmpty())
                return null;
            // 前序遍历位置进行反序列化
            // 前序遍历结果第一个节点是根节点
            int rootVal = nodes.getFirst();
            
            if (rootVal > max || rootVal < min) {
                // 超过闭区间 [min, max]，则返回空指针
                return null;
            }
            nodes.removeFirst();
            // 生成 root 节点
            TreeNode root = new TreeNode(rootVal);
            // 构建左右子树
            // BST 左子树都比根节点小，右子树都比根节点大
            root.left = deserialize(nodes, min, rootVal);
            root.right = deserialize(nodes, rootVal, max);
            return root;
        }
    }
}
