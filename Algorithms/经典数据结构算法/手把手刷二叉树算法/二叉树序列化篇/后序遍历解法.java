package Algorithms.经典数据结构算法.手把手刷二叉树算法.二叉树序列化篇;

import java.util.LinkedList;

import Algorithms.Base.TreeNode;

public class 后序遍历解法 {
    String SEP = ",";
    String NULL = "#";

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        serialize(root.right, sb);

        /****** 后序位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;
        // 从后往前取出元素
        String last = nodes.removeLast();

        if (last.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 先构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
