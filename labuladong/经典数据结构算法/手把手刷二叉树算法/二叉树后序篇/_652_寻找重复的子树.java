package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉树后序篇;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-duplicate-subtrees/
public class _652_寻找重复的子树 {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> subTrees = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    /* 辅助函数 */
    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // 先算左右子树的序列化结果
        String left = serialize(root.left);
        String right = serialize(root.right);

        String myself = left + "," + right + "," + root.val;

        int freq = subTrees.getOrDefault(myself, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        subTrees.put(myself, freq + 1);
        return myself;
    }
}
