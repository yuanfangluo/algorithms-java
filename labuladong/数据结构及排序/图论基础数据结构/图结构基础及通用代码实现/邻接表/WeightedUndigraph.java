package labuladong.数据结构及排序.图论基础数据结构.图结构基础及通用代码实现.邻接表;

import java.util.List;

// 无向加权图的通用实现
public class WeightedUndigraph {
    private WeightedDigraph graph;

    public WeightedUndigraph(int n) {
        graph = new WeightedDigraph(n);
    }

    // 增，添加一条带权重的无向边，复杂度 O(1)
    public void addEdge(int from, int to, int weight) {
        graph.addEdge(from, to, weight);
        graph.addEdge(to, from, weight);
    }

    // 删，删除一条无向边，复杂度 O(V)
    public void removeEdge(int from, int to) {
        graph.removeEdge(from, to);
        graph.removeEdge(to, from);
    }

    // 查，判断两个节点是否相邻，复杂度 O(V)
    public boolean hasEdge(int from, int to) {
        return graph.hasEdge(from, to);
    }

    // 查，返回某个节点的所有邻居节点，复杂度 O(V)
    public List<WeightedDigraph.Edge> neighbors(int v) {
        return graph.neighbors(v);
    }

    public static void main(String[] args) {
        WeightedUndigraph graph = new WeightedUndigraph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // true

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " <-> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 <-> 0, wight: 3
        // 2 <-> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
        System.out.println(graph.hasEdge(1, 0)); // false
    }
}
