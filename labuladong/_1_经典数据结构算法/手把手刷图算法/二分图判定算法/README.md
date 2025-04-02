# 判断二分图

- 给你一幅「图」，请你用两种颜色将图中的所有顶点着色，且使得任意一条边的两个端点的颜色都不相同，你能做到吗？
- 从简单实用的角度来看，二分图结构在某些场景可以更高效地存储数据。
- 比如说我们需要一种数据结构来储存电影和演员之间的关系：某一部电影肯定是由多位演员出演的，且某一位演员可能会出演多部电影。你使用什么数据结构来存储这种关系呢？
![演员和电影](https://labuladong.online/algo/images/algo4/2.jpg)
- 再举个近在眼前的例子，我的网站每篇文章末尾都会有引用该文章的题目，这就是二分图的应用：
![文章和题目](https://labuladong.online/algo/images/web_intro/ref.jpg)

## 二分图判定思路

- 说白了就是遍历一遍图，一边遍历一边染色，看看能不能用两种颜色给所有节点染色，且相邻节点的颜色都不相同。

- 既然说到遍历图，也不涉及最短路径之类的，当然是 DFS 算法和 BFS 皆可了，DFS 算法相对更常用些，所以我们先来看看如何用 DFS 算法判定双色图。

- 根据二叉树遍历框架，多叉树的遍历框架，我们可以得到图的遍历框架

```java
// 二叉树遍历框架
void traverse(TreeNode root) {
    if (root == null) return;
    traverse(root.left);
    traverse(root.right);
}

// 多叉树遍历框架
void traverse(Node root) {
    if (root == null) return;
    for (Node child : root.children)
        traverse(child);
}

// 图遍历框架
boolean[] visited;
void traverse(Graph graph, int v) {
    // 防止走回头路进入死循环
    if (visited[v]) return;
    // 前序遍历位置，标记节点 v 已访问
    visited[v] = true;
    for (Vertex neighbor : graph.neighbors(v))
        traverse(graph, neighbor);
}
```

- 因为图中可能存在环，所以用 visited 数组防止走回头路。

- 这里可以看到我习惯把 return 语句都放在函数开头，因为一般 return 语句都是 base case，集中放在一起可以让算法结构更清晰。

- 其实，如果你愿意，也可以把 if 判断放到其它地方，比如图遍历框架可以稍微改改：

```java
// 图遍历框架
boolean[] visited;
void traverse(Graph graph, int v) {
    // 前序遍历位置，标记节点 v 已访问
    visited[v] = true;
    for (int neighbor : graph.neighbors(v)) {
        if (!visited[neighbor]) {
            // 只遍历没标记过的相邻节点
            traverse(graph, neighbor);
        }
    }
}
```

- 为什么要特别说这种写法呢？因为我们判断二分图的算法会用到这种写法。

- 回顾一下二分图怎么判断，其实就是让 traverse 函数一边遍历节点，一边给节点染色，尝试让每对相邻节点的颜色都不一样。

- 所以，判定二分图的代码逻辑可以这样写：

```java
// 图遍历框架
void traverse(Graph graph, boolean[] visited, int v) {
    visited[v] = true;
    // 遍历节点 v 的所有相邻节点 neighbor
    for (int neighbor : graph.neighbors(v)) {
        if (!visited[neighbor]) {
            // 相邻节点 neighbor 没有被访问过
            // 那么应该给节点 neighbor 涂上和节点 v 不同的颜色
            traverse(graph, visited, neighbor);
        } else {
            // 相邻节点 neighbor 已经被访问过
            // 那么应该比较节点 neighbor 和节点 v 的颜色
            // 若相同，则此图不是二分图
        }
    }
}
```
