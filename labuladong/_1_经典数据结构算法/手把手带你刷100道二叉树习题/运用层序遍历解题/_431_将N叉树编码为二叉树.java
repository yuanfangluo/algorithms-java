package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/encode-n-ary-tree-to-binary-tree/
public class _431_将N叉树编码为二叉树 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution1 {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if(root == null) return null;
            TreeNode res = new TreeNode(root.val);
            if(root.children.size() > 0 ) {
                res.left = encode(root.children.get(0));
            }
            TreeNode curr = res.left;
            for (int i = 1; i < root.children.size(); i++) {
                // curr = encode(root.children.get(i));
                curr.right = encode(root.children.get(i));
                curr = curr.right;
            }
            return res;
        }
        
        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if(root == null) return null;
            Node res = new Node(root.val, new ArrayList<>());
            // res.children.add(decode(root.left));
            
            TreeNode curr = root.left;
            while(curr != null) {
                res.children.add(decode(curr));
                curr = curr.right;
            }
            return res;
        }
    }

    class Solution2 {
        class Pair {
            public Node ntNode;
            public TreeNode btNode;
    
            public Pair(Node ntNode, TreeNode btNode) {
                this.btNode = btNode;
                this.ntNode = ntNode;
            }
        }
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }

            // 二叉树的根节点
            TreeNode btRoot = new TreeNode(root.val);
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, btRoot));

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                TreeNode curBtNode = cur.btNode;
                Node curNtNode = cur.ntNode;

                // 虚拟节点，作为二叉树树枝的起点，便于处理
                TreeNode dummy = new TreeNode(-1), p = dummy;

                for (Node child : curNtNode.children) {
                    // 层序遍历，下一层的节点入队
                    TreeNode newBtNode = new TreeNode(child.val);
                    q.offer(new Pair(child, newBtNode));
                    // 同时把下一层的节点都穿在二叉树节点的右侧树枝上
                    p.right = newBtNode;
                    p = p.right;
                }
                // 把这个树枝挂在父节点的左子树上
                curBtNode.left = dummy.right;
            }
            return btRoot;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            // N 叉树的根节点
            Node ntRoot = new Node(root.val, new ArrayList<>());
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(ntRoot, root));

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                TreeNode curBtNode = cur.btNode;
                Node curNtNode = cur.ntNode;

                ArrayList<Node> children = new ArrayList<>();
                // 挂在左子树上的树枝上的节点就是 n 叉树的孩子节点
                for (TreeNode p = curBtNode.left; p != null; p = p.right) {
                    Node newNtNode = new Node(p.val);
                    // 将子节点入队
                    q.offer(new Pair(newNtNode, p));
                    children.add(newNtNode);
                }
                curNtNode.children = children;
            }
            return ntRoot;
        }
    }
}
