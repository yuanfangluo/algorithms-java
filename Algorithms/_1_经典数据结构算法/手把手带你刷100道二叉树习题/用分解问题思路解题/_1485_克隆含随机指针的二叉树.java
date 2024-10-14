package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.HashMap;

// https://leetcode.cn/problems/clone-binary-tree-with-random-pointer/
public class _1485_克隆含随机指针的二叉树 {
    // 这道题和一般的二叉树构造问题思路是一样的，函数的定义就是复制二叉树并返回根节点，那么把根节点构造出来之后，递归调用子节点就行了，基本算法框架肯定是这样：
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.random = null;
        }
    }

    class NodeCopy {
        public int val;
        public NodeCopy left;
        public NodeCopy right;
        public NodeCopy random;

        public NodeCopy(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.random = null;
        }
    }
    // 定义：输入一棵二叉树的根节点 root，复制这棵树并返回复制后的根节点
    // 这道题的特殊之处在于 random 节点，可能指向任何节点，
    // 如果这个节点还没被构建出来，你应该把它 new 出来，
    // 但如果这个节点已经被构建出来了，你直接把 random 指针指向这个节点就行了。

    // 想做到这一点也很简单，用一个 HashMap 存储原始节点到复制节点的映射就行了，这样就能知道哪些节点已经被构建出来了。

    // 原始节点到复制节点的映射
    HashMap<Node, NodeCopy> nodeToCopy = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }

        if (nodeToCopy.containsKey(root)) {
            return nodeToCopy.get(root);
        }

        // 在前序位置把自己存入 map 映射，之后如果有 random 指针指向自己的话可以直接从 map 里面拿出来
        NodeCopy rootCopy = new NodeCopy(root.val);
        nodeToCopy.put(root, rootCopy);

        // 根据函数定义递归构造三个子节点
        rootCopy.left = copyRandomBinaryTree(root.left);
        rootCopy.right = copyRandomBinaryTree(root.right);
        rootCopy.random = copyRandomBinaryTree(root.random);

        return rootCopy;
    }

}
