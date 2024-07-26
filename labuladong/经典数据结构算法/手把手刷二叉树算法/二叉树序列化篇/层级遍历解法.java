package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉树序列化篇;

import java.util.LinkedList;
import java.util.Queue;
import labuladong.Base.TreeNode;

public class 层级遍历解法 {
    String SEP = ",";
    String NULL = "#";

    /* 将二叉树序列化为字符串 */
    String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 层级遍历代码位置 */
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);
                /*****************/
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    /* 将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // index 变量记录正在序列化的节点在数组中的位置
        int index = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode parent = q.poll();
                // 为父节点构造左侧子节点
                String left = nodes[index++];
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }
                // 为父节点构造右侧子节点
                String right = nodes[index++];
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }
}
