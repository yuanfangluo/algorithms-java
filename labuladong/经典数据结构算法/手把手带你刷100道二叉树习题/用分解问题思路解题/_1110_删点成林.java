package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/delete-nodes-and-return-forest/
public class _1110_删点成林 {
    Set<Integer> delSet = new HashSet<>();

    // 记录森林的根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null)
            return new LinkedList<>();
        for (int d : to_delete) {
            delSet.add(d);
        }
        doDelete(root, false);
        return res;
    }

    // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
    private TreeNode doDelete(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }

        // 判断是否需要被删除
        boolean deleted = delSet.contains(root.val);
        if (!deleted && !hasParent) {
            // 没有父节点且不需要被删除，就是一个新的根节点

            res.add(root);
        }

        // 去左右子树进行删除
        root.left = doDelete(root.left, !deleted);
        root.right = doDelete(root.right, !deleted);

        // 如果需要被删除，返回 null 给父节点
        return deleted ? null : root;
    }

    class Solution {
        List<TreeNode> ans = new ArrayList<>();
        boolean[] delete = new boolean[1001];

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int i = 0; i < to_delete.length; i++) {
                delete[to_delete[i]] = true;
            }
            dfs(root, true);
            return ans;
        }

        public void dfs(TreeNode root, boolean flag) {
            if (root == null)
                return;
            if (delete[root.val]) {
                dfs(root.left, true);
                dfs(root.right, true);
            } else {
                if (flag)
                    ans.add(root);
                dfs(root.left, false);
                dfs(root.right, false);
            }
            if (root.left != null && delete[root.left.val])
                root.left = null;
            if (root.right != null && delete[root.right.val])
                root.right = null;
        }

    }

}
