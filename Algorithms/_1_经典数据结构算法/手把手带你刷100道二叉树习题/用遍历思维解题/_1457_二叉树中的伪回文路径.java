package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/
public class _1457_二叉树中的伪回文路径 {
    // 如果一组数字中，只有最多一个数字出现的次数为奇数，剩余数字的出现次数均为偶数，那么这组数字可以组成一个回文串。
    int res = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return res;
    }

    int[] count = new int[10];
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            // 叶子节点，此时可以判断是否是伪回文串
            // count[root.val] = count[root.val] + 1;
            // count[root.val] += 1;
            count[root.val]++;
            // 如果路径上出现奇数次的数字个数大于 1，则不可能组成回文串，反之则可以组成回文串
            int odd = 0;
            for(int n : count) {
                // 对于一个整数 n ，如果 n & 1 == 0 ，则 n 是偶数；如果 n & 1 == 1 ，则 n 是奇数。
                if ((n & 1) == 1) { // 奇数
                    odd++;
                }
            }
            if (odd <= 1) {
                res++;
            }

            count[root.val]--;
            return;
        }

        count[root.val]++;
        // 二叉树遍历框架
        traverse(root.left);
        traverse(root.right);
        count[root.val]--;
    }
}

class Solution2 {
    int res = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return res;
    }

    int count = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count = count ^ (1 << root.val);
            if ((count & (count - 1)) == 0) {
                res++;
            }
            count = count ^ (1 << root.val);
            return;
        }

        count = count ^ (1 << root.val);
        traverse(root.left);
        traverse(root.right);
        count = count ^ (1 << root.val);
    }
}
