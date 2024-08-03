package Algorithms._1_经典数据结构算法.手把手刷图算法.Kruskal最小生成树算法;

import java.util.Arrays;

import Algorithms.Base.UF;

// https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
public class _1135_最低成本连通所有城市 {
    // 树的判定算法加上按权重排序的逻辑就变成了 Kruskal 算法。
    class Solution {
        int minimumCost(int n, int[][] connections) {
            // 城市编号为 1...n，所以初始化大小为 n + 1
            UF uf = new UF(n + 1);
            // 对所有边按照权重从小到大排序
            Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
            // 记录最小生成树的权重之和
            int mst = 0;
            for (int[] edge : connections) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                // 若这条边会产生环，则不能加入 mst
                if (uf.connected(u, v)) {
                    continue;
                }
                // 若这条边不会产生环，则属于最小生成树
                mst += weight;
                uf.union(u, v);
            }
            // 保证所有节点都被连通
            // 按理说 uf.count() == 1 说明所有节点被连通
            // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
            return uf.count() == 2 ? mst : -1;
        }
    }
}
