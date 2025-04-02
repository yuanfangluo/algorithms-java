package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.cn/problems/tree-diameter/
public class _1245_树的直径 {
    class Solution {
        int res = 0; // 树的直径
        public int treeDiameter(int[][] edges) {
            int n = edges.length + 1;
            List<Integer>[] adjList = new List[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                adjList[u].add(v);
                adjList[v].add(u);
            }
            dp(adjList,0,-1);
            return res;
        }
    
        public int dp(List<Integer>[] adjList, int u, int p) {
            // 遍历每一个子节点
            int maxLen = 0; // 单挑分支的最大长度，需要返回的
            for (int v : adjList[u]) {
                if (v == p) continue;
                int len = dp(adjList, v, u) + 1;
                // 使用len和maxLen更新最大直径
                res = Math.max(res, len + maxLen);
                maxLen = Math.max(len, maxLen);
            }
            return maxLen;
        }
    
    }
    class Solution2 {
    // 记录最大直径的长度
    int maxDiameter = 0;

    // 用无向图邻接表的形式存储的一棵多叉树
    HashMap<Integer, List<Integer>> tree = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!tree.containsKey(a)) {
                tree.put(a, new ArrayList<>());
            }
            if (!tree.containsKey(b)) {
                tree.put(b, new ArrayList<>());
            }
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 以任意一个节点为根节点，开始计算最大深度
        maxDepth(edges[0][0]);
        return maxDiameter;
    }

    int maxDepth(int root) {
        if (visited.contains(root)) {
            // 已经遍历过，不要再遍历
            return 0;
        }
        visited.add(root);

        int firstMaxDepth = 0, secondMaxDepth = 0;
        for (int child : tree.get(root)) {
            int chlidDepth = maxDepth(child);
            if (chlidDepth >= firstMaxDepth) {
                secondMaxDepth = firstMaxDepth;
                firstMaxDepth = chlidDepth;
            } else if (chlidDepth > secondMaxDepth) {
                secondMaxDepth = chlidDepth;
            }
        }
        // 后序位置，顺便计算最大直径
        // 穿过当前节点 root 的最大直径，是子树中最大深度最大的那两个之和
        int myDiameter = firstMaxDepth + secondMaxDepth;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + firstMaxDepth;
    }
}
}
