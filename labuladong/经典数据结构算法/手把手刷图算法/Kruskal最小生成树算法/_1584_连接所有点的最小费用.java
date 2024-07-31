package labuladong.经典数据结构算法.手把手刷图算法.Kruskal最小生成树算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import labuladong.Base.UF;

// https://leetcode.cn/problems/min-cost-to-connect-all-points/
public class _1584_连接所有点的最小费用 {
    // 很显然这也是一个标准的最小生成树问题：
    // 每个点就是无向加权图中的节点，边的权重就是曼哈顿距离，连接所有点的最小费用就是最小生成树的权重和。
    // 所以解法思路就是先生成所有的边以及权重，然后对这些边执行 Kruskal 算法即可：
    class Solution {
        int minCostConnectPoints(int[][] points) {
            int n = points.length;

            // 生成所有边及权重
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    // 用坐标点在 points 中的索引表示坐标点
                    edges.add(new int[] {
                            i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                    });
                }
            }

            // 将边按照权重从小到大排序
            Collections.sort(edges, (a, b) -> {
                return a[2] - b[2];
            });
            
            // 执行 Kruskal 算法
            int mst = 0;
            UF uf = new UF(n);
            for (int[] edge : edges) {
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
            return mst;
        }
    }

}
