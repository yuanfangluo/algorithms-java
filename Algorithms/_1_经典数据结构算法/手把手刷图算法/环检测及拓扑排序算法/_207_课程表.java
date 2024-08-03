package Algorithms._1_经典数据结构算法.手把手刷图算法.环检测及拓扑排序算法;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/course-schedule/
public class _207_课程表 {
    // 看到依赖问题，首先想到的就是把问题转化成「有向图」这种数据结构，只要图中存在环，那就说明存在循环依赖。

    // 分解步骤
    // 1、可以写一个建图函数：
    // 2、图的dfs算法遍历框架
    class Solution1 {
        // 记录一次递归堆栈中的节点，用来判断环
        boolean[] onPath;

        // 记录遍历过的节点，防止走回头路
        boolean[] visited;

        // 记录图中是否有环
        boolean hasCycle = false;

        boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            
            // 遍历图中的所有节点
            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }
            // 只要没有循环依赖可以完成所有课程
            return !hasCycle;
        }

        void traverse(List<Integer>[] graph, int s) {
            if (onPath[s]) {
                // 出现环
                hasCycle = true;
            }

            if (visited[s] || hasCycle) {
                // 如果已经找到了环，也不用再遍历了
                return;
            }

            // 前序代码位置
            visited[s] = true;
            onPath[s] = true;

            // 递归遍历相邻节点
            for (int t : graph[s]) {
                traverse(graph, t);
            }

            // 后序代码位置
            onPath[s] = false;
        }

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

    // 环检测算法，BFS 的解法代码
    // 我先总结下这段 BFS 算法的思路：
    // 1、构建邻接表，和之前一样，边的方向表示「被依赖」关系。
    // 2、构建一个 indegree 数组记录每个节点的入度，即 indegree[i] 记录节点 i 的入度。
    // 3、对 BFS 队列进行初始化，将入度为 0 的节点首先装入队列。
    // 4、开始执行 BFS 循环，不断弹出队列中的节点，减少相邻节点的入度，并将入度变为 0 的节点加入队列。
    // 5、如果最终所有节点都被遍历过（count 等于节点数），则说明不存在环，反之则说明存在环。
    
    class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图，有向边代表「被依赖」关系
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 节点 to 的入度加一
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点 i 没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                q.offer(i);
            }
        }

        // 记录遍历的节点个数
        int count = 0;
        // 开始执行 BFS 循环
        while (!q.isEmpty()) {
            // 弹出节点 cur，并将它指向的节点的入度减一
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    q.offer(next);
                }
            }
        }

        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
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

}
