package labuladong.手把手刷数据结构.手把手刷二叉树算法.二叉树序列化篇;

import labuladong.Base.TreeNode;

public class 中序遍历解法 {
    // 先说结论，中序遍历的方式行不通，因为无法实现反序列化方法 deserialize。
    // 序列化方法 serialize 依然容易，只要把字符串的拼接操作放到中序遍历的位置就行了：

    String SEP = ",";
    String NULL = "#";

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        /******* 中序位置 *******/
        sb.append(root.val).append(SEP);
        /***********************/
        serialize(root.right, sb);
    }

}
