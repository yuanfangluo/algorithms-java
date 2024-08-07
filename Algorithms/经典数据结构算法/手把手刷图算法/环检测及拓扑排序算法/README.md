# 图的算法

- 图这种数据结构有一些比较特殊的算法，
- 比如二分图判断，
- 有环图无环图的判断，
- 拓扑排序，
- 以及最经典的最小生成树，
- 单源最短路径问题，
- 更难的就是类似网络流这样的问题。

## 有向图的环检测

- 例如课程表依赖问题

## 拓扑排序算法

### DFS

- 课程表进阶版：不是仅仅让你判断是否可以完成所有课程，而是进一步让你返回一个合理的上课顺序，保证开始修每个课程时，前置的课程都已经修完。

- 直观地说就是，让你把一幅图「拉平」，而且这个「拉平」的图里面，所有箭头方向都是一致的
![拓扑排序](https://labuladong.online/algo/images/%E6%8B%93%E6%89%91%E6%8E%92%E5%BA%8F/top.jpg)
- 如果一幅有向图中存在环，是无法进行拓扑排序的，因为肯定做不到所有箭头方向一致；反过来，如果一幅图是「有向无环图」，那么一定可以进行拓扑排序。

### 执行拓扑排序之前需要判断图是否无环

- 将后序遍历的结果进行反转，就是拓扑排序的结果（因为我们定义的有向边课程from到课程to，需要先修完课程from，再能修课程to）

### 那么为什么后序遍历的反转结果就是拓扑排序呢？

- 用一个直观地例子来解释，我们就说二叉树，这是我们说过很多次的二叉树遍历框架：

```java
void traverse(TreeNode root) {
    // 前序遍历代码位置
    traverse(root.left)
    // 中序遍历代码位置
    traverse(root.right)
    // 后序遍历代码位置
}
```

- 二叉树的后序遍历是什么时候？
- 遍历完左右子树之后才会执行后序遍历位置的代码。换句话说，当左右子树的节点都被装到结果列表里面了，根节点才会被装进去。
- 后序遍历的这一特点很重要，之所以拓扑排序的基础是后序遍历，是因为一个任务必须等到它依赖的所有任务都完成之后才能开始开始执行。
- 你把二叉树理解成一幅有向图，边的方向是由父节点指向子节点，那么就是下图这样：
- 对于标准的后序遍历结果，根节点出现在最后，只要把遍历结果反过来，就是拓扑排序结果：

### BFS

- BFS 版本的拓扑排序算法，因为节点的遍历顺序就是拓扑排序的结果。
- 所以我们可以用 BFS 来实现拓扑排序。
