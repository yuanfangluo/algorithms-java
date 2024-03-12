package LeetCode._3_二叉树;

import LeetCode.Base.TreeNode;

public class 每个节点的左右子树的节点个数 {

    // 定义：输入一棵二叉树，返回这棵二叉树的节点总数
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        // 后序位置
        System.out.println(root);
        System.out.println("左子树有" + leftCount + "个节点，右子树有" + rightCount + "个节点");
        return leftCount + rightCount + 1;
    }
}
