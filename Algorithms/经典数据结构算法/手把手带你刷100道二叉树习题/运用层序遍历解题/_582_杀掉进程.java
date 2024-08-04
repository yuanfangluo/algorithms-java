package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/kill-process/
public class _582_杀掉进程 {
    // 如果是一棵常规的二叉树，让你从中摘除一棵子树，你会不会？应该很简单对吧，遍历一遍找到子树的根节点，然后从整棵树中摘除就行了。

    // 但本题的难点是我们只有子节点到父节点的引用，和常规二叉树不同，这样就无法用常规的二叉树遍历算法从根节点去遍历整棵树了。

    // 怎么办？很简单，把它转化成常规的二叉树不就行了？
    // 先把题目输入的这棵树转化成常规形式（父节点指向子节点），然后执行遍历算法（DFS/BFS 都可以）去遍历删除以目标节点 kill 为根的整棵子树。

    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            // 构建多叉树，key 为父节点，value 为所有子节点的列表
            HashMap<Integer, List<Integer>> tree = new HashMap<>();
            for (int i = 0; i < pid.size(); i++) {
                int child = pid.get(i);
                int parent = ppid.get(i);
                tree.putIfAbsent(parent, new ArrayList<>());
                tree.get(parent).add(child);
            }

            List<Integer> res = new LinkedList<>();
            // 我这里用 BFS 算法遍历子树，删除以 kill 为根的所有子节点
            Queue<Integer> q = new LinkedList<>();
            q.offer(kill);
            while (!q.isEmpty()) {
                int cur = q.poll();
                res.add(cur);
                if (tree.containsKey(cur)) {
                    // 所有子节点入队
                    q.addAll(tree.get(cur));
                }
            }
            return res;
        }
    }
}
