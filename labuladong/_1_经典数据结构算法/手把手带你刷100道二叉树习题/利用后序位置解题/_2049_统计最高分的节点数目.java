package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import java.util.HashMap;

// https://leetcode.cn/problems/count-nodes-with-the-highest-score/
public class _2049_统计最高分的节点数目 {
    // 一个节点的 分数 = 左子树节点个数 x 右子树节点个数 x 除自己外其他节点个数。
    // 只要写个 countNode 函数，在后序位置可以得到左右子树的节点个数 leftCount 和 rightCount，
    // 然后除自己外其他节点个数 otherCount 就等于总的节点个数 n 减掉左右子树的节点个数再减掉当前节点，
    // 最后求个乘积就能算出当前节点的「分数」了。

    class Solution {
        // 用邻接表表示的一棵二叉树
        int[][] tree;
        HashMap<Long, Integer> scoreToCount = new HashMap<>();

        public int countHighestScoreNodes(int[] parents) {
            this.tree = buildTree(parents);
            countNode(0);
            // 计算最大分数出现的次数
            long maxScore = 0;
            for (long score : scoreToCount.keySet()) {
                maxScore = Math.max(maxScore, score);
            }
            return scoreToCount.get(maxScore);
        }

        // 计算二叉树中的节点个数
        int countNode(int root) {
            if (root == -1) {
                return 0;
            }
            // 二叉树中节点总数
            int n = tree.length;
            int leftCount = countNode(tree[root][0]);
            int rightCount = countNode(tree[root][1]);

            // 后序位置，计算每个节点的「分数」
            int otherCount = n - leftCount - rightCount - 1;
            // 注意，这里要把 int 转化成 long，否则会产生溢出！！！
            long score = (long) Math.max(leftCount, 1)
                    * Math.max(rightCount, 1) * Math.max(otherCount, 1);
            // 给分数 score 计数
            scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);

            return leftCount + rightCount + 1;
        }

        // 将 parents 数组转化成常规二叉树（邻接表形式）
        int[][] buildTree(int[] parents) {
            int n = parents.length;
            // 表节点 x 的左子节点为 tree[x][0]，节点 x 的右子节点为 tree[x][1]
            // 若 tree[x][0] 或 tree[x][1] 等于 -1 则代表空指针
            int[][] tree = new int[n][2];
            for (int i = 0; i < n; i++) {
                // 先都初始化成空指针
                tree[i][0] = tree[i][1] = -1;
            }
            // 根据 parents 数组构建二叉树（跳过 parents[0] 根节点）
            for (int i = 1; i < n; i++) {
                int parent_i = parents[i];
                if (tree[parent_i][0] == -1) {
                    tree[parent_i][0] = i;
                } else {
                    tree[parent_i][1] = i;
                }
            }
            return tree;
        }
    }

    
}
