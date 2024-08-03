package Algorithms._1_经典数据结构算法.手把手刷图算法.并查集算法;

import Algorithms.Base.UF;

// https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/
public class _323_无向图中连通分量的数目 {
    // 这道题我们可以直接套用 UF 类来解决：
    class Solution {
        public int countComponents(int n, int[][] edges) {
            UF uf = new UF(n);
            // 将每个节点进行连通
            for (int[] e : edges) {
                uf.union(e[0], e[1]);
            }
            // 返回连通分量的个数
            return uf.count();
        }
    }
}
