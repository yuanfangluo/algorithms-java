package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
public class LCR_143_子结构判断 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        
        private boolean dfs(TreeNode A, TreeNode B) {
            // B 遍历完了，说明是子结构
            if (B == null) return true;
            // A 遍历完了，B 还没遍历完，说明不是子结构

            if (A == null || A.val!= B.val) return false;
            // 继续判断左右子树是否是子结构
            // 注意：这里的 && 是短路的，只要有一个 false，就不会继续判断了
            // 所以这里的 && 是有必要的
            // 因为如果 A.val == B.val，那么就会继续判断左右子树是否是子结构
            // 如果 A.val!= B.val，那么就不会继续判断左右子树是否是子结构
            // 所以这里的 && 是有必要的
            return dfs(A.left, B.left) && dfs(A.right, B.right);
        }
    }
}
