package Algorithms.数据结构及排序.二叉树结构及遍历.二叉树的遍历;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.TreeNode;

// BFS，需要借助队列
public class 二叉树的层序遍历框架 {
    // 不需要记录depth
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

    // 需要记录depth
    class Solution2 {
        void levelOrderTraverse(TreeNode root) {
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
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                depth++;
            }
        }
    }

    // 记录权重和
    class Solution3 {
        class State {
            TreeNode node;
            int depth;
        
            State(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
        
        void levelOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<State> q = new LinkedList<>();
            // 根节点的路径权重和是 1
            q.offer(new State(root, 1));
        
            while (!q.isEmpty()) {
                State cur = q.poll();
                // 访问 cur 节点，同时知道它的路径权重和
                System.out.println("depth = " + cur.depth + ", val = " + cur.node.val);
        
                // 把 cur 的左右子节点加入队列
                if (cur.node.left != null) {
                    q.offer(new State(cur.node.left, cur.depth + 1));
                }
                if (cur.node.right != null) {
                    q.offer(new State(cur.node.right, cur.depth + 1));
                }
            }
        }
    }
}
