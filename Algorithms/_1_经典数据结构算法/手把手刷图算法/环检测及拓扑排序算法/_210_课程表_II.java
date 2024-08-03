package Algorithms._1_经典数据结构算法.手把手刷图算法.环检测及拓扑排序算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/course-schedule-ii/

public class _210_课程表_II {
    // 分析流程
    // 我们先判断一下题目输入的课程依赖是否成环，成环的话是无法进行拓扑排序的，所以我们可以复用上一道题的主函数
    // 如何进行拓扑排序？
    // 将后序遍历的结果进行反转，就是拓扑排序的结果
    // 代码虽然看起来多，但是逻辑应该是很清楚的，
    // 只要图中无环，那么我们就调用 traverse 函数对图进行 DFS 遍历，记录后序遍历结果，
    // 最后把后序遍历结果反转，作为最终的答案
    // 那么为什么后序遍历的反转结果就是拓扑排序呢？
    // 二叉树的后序遍历是什么时候？
    // 遍历完左右子树之后才会执行后序遍历位置的代码。
    // 换句话说，当左右子树的节点都被装到结果列表里面了，根节点才会被装进去。
    // 后序遍历的这一特点很重要，之所以拓扑排序的基础是后序遍历，是因为一个任务必须等到它依赖的所有任务都完成之后才能开始开始执行。

    class Solution1 {
        // 记录后序遍历结果
        List<Integer> postorder = new ArrayList<>();

        // 记录是否存在环
        boolean hasCycle = false;
        boolean[] visited, onPath;

        // 主函数
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            // 遍历图
            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }

            // 有环图无法进行拓扑排序
            if (hasCycle) {
                return new int[] {};
            }
            // 逆后序遍历结果即为拓扑排序结果
            Collections.reverse(postorder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postorder.get(i);
            }
            return res;
        }

        // 图遍历函数
        void traverse(List<Integer>[] graph, int s) {
            if (onPath[s]) {
                // 发现环
                hasCycle = true;
            }
            if (visited[s] || hasCycle) {
                return;
            }
            // 前序遍历位置
            onPath[s] = true;
            visited[s] = true;
            for (int t : graph[s]) {
                traverse(graph, t);
            }
            // 后序遍历位置
            postorder.add(s);
            onPath[s] = false;
        }

        // 建图函数
        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            // 图中共有 numCourses 个节点
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 添加一条从 from 指向 to 的有向边
                // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
                graph[from].add(to);
            }
            return graph;
        }
    }

    // 拓扑排序算法（BFS 版本）
    // 我们稍微修改一下 BFS 版本的环检测算法，记录节点的遍历顺序即可得到拓扑排序的结果
    class Solution2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 建图，和环检测算法相同
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // 计算入度，和环检测算法相同
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                indegree[to]++;
            }

            // 根据入度初始化队列中的节点，和环检测算法相同
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // 记录拓扑排序结果
            int[] res = new int[numCourses];
            // 记录遍历节点的顺序（索引）
            int count = 0;
            // 开始执行 BFS 算法
            while (!q.isEmpty()) {
                int cur = q.poll();
                // 弹出节点的顺序即为拓扑排序结果
                res[count] = cur;
                count++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            if (count != numCourses) {
                // 存在环，拓扑排序不存在
                return new int[] {};
            }
            return res;
        }

        // 建图函数
        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            // 图中共有 numCourses 个节点
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 修完课程 from 才能修课程 to
                // 在图中添加一条从 from 指向 to 的有向边
                graph[from].add(to);
            }
            return graph;
        }
    }
}
