package Algorithms.经典数据结构算法.手把手刷图算法.Kruskal最小生成树算法;

public class kruskal {
    // 主要的难点是利用 Union-Find 并查集算法向最小生成树中添加边，配合排序的贪心思路，从而得到一棵权重之和最小的生成树。

    // 最后说下 Kruskal 算法的复杂度分析：

    // 假设一幅图的节点个数为 V，边的条数为 E，首先需要 O(E) 的空间装所有边，而且 Union-Find 算法也需要 O(V) 的空间，
    // 所以 Kruskal 算法总的空间复杂度就是 O(V + E)。

    // 时间复杂度主要耗费在排序，需要 O(ElogE) 的时间，Union-Find 算法所有操作的复杂度都是 O(1)，套一个 for 循环也不过是
    // O(E)，
    // 所以总的时间复杂度为 O(ElogE)。
}
