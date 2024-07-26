package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-cameras/
public class _968_监控二叉树 {
    // 首先我们列举一下一个节点可能存在的几种状态：
    // 该节点不在监控区域内，称为 uncover 状态；
    // 该节点在附近节点的监控范围内，称为 cover 状态；
    // 该节点自己装了摄像头，称为 set 状态。
    // 如何保证安装的摄像头数量尽可能少呢？显然就是要尽可能分散，让每个摄像头物尽其用。
    // 具体来说就是自底向上安装摄像头，在叶子节点的父节点上安装摄像头，然后每隔两层再安装（因为每个摄像头都可以管三层）。
    // 那么一个节点在什么情况下需要被安装摄像头呢？显然是当这个节点的子节点处于 uncover 的状态的时候必须安装摄像头，以便覆盖子节点。
    // 综上，我们需要利用后序位置自底向上遍历二叉树，同时要利用子节点的状态以及父节点的状态，判断当前节点是否需要安装摄像头。
    class Solution {
        int res = 0;

        public int minCameraCover(TreeNode root) {
            setCamera(root, false);
            return res;
        }

        // 定义：输入以 root 为根的二叉树，以最优策略在这棵二叉树上放置摄像头，
        // 然后返回 root 节点的情况：
        // 返回 -1 代表 root 为空，返回 0 代表 root 未被 cover，
        // 返回 1 代表 root 已经被 cover，返回 2 代表 root 上放置了摄像头。
        int setCamera(TreeNode root, boolean hasParent) {
            if (root == null) {
                return -1;
            }

            // 获取左右子节点的情况
            int left = setCamera(root.left, true);
            int right = setCamera(root.right, true);

            // 根据左右子节点的情况和父节点的情况判断当前节点应该做的事情
            if (left == -1 && right == -1) {
                // 当前节点是叶子节点
                if (hasParent) {
                    // 有父节点的话，让父节点来 cover 自己
                    return 0;
                }
                // 没有父节点的话，自己 set 一个摄像头
                res++;
                return 2;
            }

            if (left == 0 || right == 0) {
                // 左右子树存在没有被 cover 的
                // 必须在当前节点 set 一个摄像头
                res++;
                return 2;
            }

            if (left == 2 || right == 2) {
                // 左右子树只要有一个 set 了摄像头
                // 当前节点就已经是 cover 状态了
                return 1;
            }

            // 剩下 left == 1 && right == 1 的情况
            // 即当前节点的左右子节点都被 cover
            if (hasParent) {
                // 如果有父节点的话，可以等父节点 cover 自己
                return 0;
            } else {
                // 没有父节点，只能自己 set 一个摄像头
                res++;
                return 2;
            }
        }
    }
    
    class Solution2 {
        int res = 0;
        public int minCameraCover(TreeNode root) {
            if (minCame(root) == 0)
                res++;
            return res;

        }

        public int minCame(TreeNode root) {
            if (root == null) {
                return 2;
            }

            int left = minCame(root.left);
            int right = minCame(root.right);

            if (left == 2 && right == 2) {
                return 0;
            } else if (left == 0 || right == 0) {
                res++;
                return 1;
            } else {
                return 2;
            }
        }
    }
}
