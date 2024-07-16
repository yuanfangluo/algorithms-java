package labuladong.手把手刷数据结构.手把手刷二叉树算法.二叉树构造篇;

import java.util.HashMap;
import java.util.Map;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class _105_从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> valToIndex = new HashMap<>();

    // 我们肯定要想办法确定根节点的值，把根节点做出来，然后递归构造左右子树即可
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // 根据前序遍历第一个元素为root节点，在中序遍历找到该值所在的位置
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

}
