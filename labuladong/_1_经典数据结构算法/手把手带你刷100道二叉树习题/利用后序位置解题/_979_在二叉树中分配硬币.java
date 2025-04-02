package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/distribute-coins-in-binary-tree/
public class _979_在二叉树中分配硬币 {
    // 如果一个节点的硬币个数是 x，无论是移出还是移入，把该节点的硬币个数变成 1 的最少移动次数必然是 abs(x - 1)。
    // 假想你现在站在某个根节点上，你如何知道把当前这棵子树的所有节点配平所需的最小移动次数？
    // 你假想多余的和缺少的硬币都移动到根节点去配平，当然根节点本身也要配平，所以整棵树配平的移动次数就是：

    // 让当前这棵树平衡所需的移动次数
    // Math.abs(left) + Math.abs(right) + (root.val - 1);

    class Solution {
        int res = 0;
        public int distributeCoins(TreeNode root) {
            getRest(root);
            return res;
        }
    
    
        // 定义：返回每个子节点都有一个硬币后多出来硬币数
        // 大于0，说明有多余，小于0说明不够，等于0说明刚好分配完
        // 定义：输入一棵二叉树，返回这棵二叉树中多出的硬币个数，返回负数代表缺少硬币
        int getRest(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = getRest(root.left);
            int right = getRest(root.right);

            // 让当前这棵树平衡所需的移动次数
            // Math.abs(left) + Math.abs(right) + (root.val - 1);
            res += Math.abs(left) + Math.abs(right) + (root.val - 1);

            // 实现函数的定义
            return left + right + (root.val - 1);
        }
    }
}
