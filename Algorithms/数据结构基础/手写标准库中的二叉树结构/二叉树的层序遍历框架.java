package Algorithms.数据结构基础.手写标准库中的二叉树结构;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.TreeNode;

public class 二叉树的层序遍历框架 {
    class Solution1 {
        void levelOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    class Solution2 {

        public static void main(String[] args) {
            TreeNode root = new TreeNode(-1);
            levelOrderTraverse(root);
        }

       static void levelOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // 记录当前遍历到的层数（根节点视为第 1 层）
            int depth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    System.out.println("值是：" + cur.val);
                    System.out.println("层数是：" + depth); 
                    if (cur.left!= null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right!= null) {
                        queue.offer(cur.right);
                    }
                }
                depth++;
            }
        }
    }

}
