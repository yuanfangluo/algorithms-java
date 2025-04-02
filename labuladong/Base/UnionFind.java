package labuladong.Base;

public class UnionFind {
    // 连通分量个数
    int count;
    // 存储每个节点的父节点
    int[] parent;

    public UnionFind(int n) {

        this.count = n;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int index1, int index2) {
        int rootP = find(index1);
        int rootQ = find(index2);
        return rootP == rootQ;
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    /* 返回当前的连通分量个数 */
    public int count() {
        return count;
    }
}
