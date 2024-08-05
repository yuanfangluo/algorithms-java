package Algorithms.经典数据结构算法.手把手刷图算法.Kruskal最小生成树算法;

import Algorithms.Base.UF;

// https://leetcode.cn/problems/graph-valid-tree/
public class _261_以图判树 {
    // 对于这道题，我们可以思考一下，什么情况下加入一条边会使得树变成图（出现环）？
    // 总结一下规律就是：
    // 对于添加的这条边，如果该边的两个节点本来就在同一连通分量里，那么添加这条边会产生环；
    // 反之，如果该边的两个节点不在同一连通分量里，则添加这条边不会产生环。

    // 而判断两个节点是否连通（是否在同一个连通分量中）就是 Union-Find 算法的拿手绝活，所以这道题的解法代码如下：

    class Solution {
        // 判断输入的若干条边是否能构造出一棵树结构
        public boolean validTree(int n, int[][] edges) {
            // 初始化 0...n-1 共 n 个节点
            UF uf = new UF(n);
            // 遍历所有边，将组成边的两个节点进行连接
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                // 若两个节点已经在同一连通分量中，会产生环
                if (uf.connected(u, v)) {
                    return false;
                }

                // 这条边不会产生环，可以是树的一部分
                uf.union(u, v);
            }
            
            // 要保证最后只形成了一棵树，即只有一个连通分量
            return uf.count() == 1;
        }
    }

}
