package Algorithms.核心框架汇总.BFS算法解题套路框架;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.cn/problems/open-the-lock/
public class _752_打开转盘锁 {
    // 首先我们不管所有的限制条件，不管 deadends 和 target 的限制，就思考一个问题：
    // 如果让你设计一个算法，穷举所有可能的密码组合，你怎么做？
    class Solution0 {
        // BFS 框架，打印出所有可能的密码
        void BFS(String target) {
            Queue<String> q = new LinkedList<>();
            q.offer("0000");

            while (!q.isEmpty()) {
                int sz = q.size();
                /* 将当前队列中的所有节点向周围扩散 */
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    /* 判断是否到达终点 */
                    System.out.println(cur);

                    /* 将一个节点的相邻节点加入队列 */
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        String down = minusOne(cur, j);
                        q.offer(up);
                        q.offer(down);
                    }
                }
                /* 在这里增加步数 */
            }
            return;
        }
    }
    // 上面代码的问题
    // 1、会走回头路。比如说我们从 "0000" 拨到 "1000"，但是等从队列拿出 "1000" 时，还会拨出一个 "0000"，这样的话会产生死循环。
    // 2、没有终止条件。按照题目要求，我们找到 target 就应该结束并返回拨动的次数。
    // 3、没有对 deadends 的处理，按道理这些「死亡密码」是不能出现的，也就是说你遇到这些密码的时候需要跳过

    // BFS算法
    class Solution1 {
        int openLock(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) {
                deads.add(s);
            }
            // 记录已经穷举过的密码，防止走回头路
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            // 从起点开始启动广度优先搜索
            int step = 0;
            q.offer("0000");
            visited.add("0000");
            while (!q.isEmpty()) {
                int sz = q.size();
                /* 将当前队列中的所有节点向周围扩散 */
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    if (deads.contains(cur)) {
                        continue;
                    }
                    /* 判断是否到达终点 */
                    if (cur.equals(target)) {
                        return step;
                    }

                    /* 将一个节点的未遍历相邻节点加入队列 */
                    for (int j = 0; j < 4; j++) {
                        // 向上拨动
                        String up = plusOne(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }

                        // 向下拨动
                        String down = minusOne(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                /* 在这里增加步数 */
                step++;
            }
            // 如果穷举完都没找到目标密码，那就是找不到了
            return -1;
        }
    }

    // 将 s[i] 向上拨动一次
    String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9')
            ch[i] = '0';
        else
            ch[i] += 1;
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0')
            ch[i] = '9';
        else
            ch[i] -= 1;
        return new String(ch);
    }

    // 双向 BFS 优化
    // 你以为到这里 BFS 算法就结束了？
    // 恰恰相反。BFS 算法还有一种稍微高级一点的优化思路：双向 BFS，可以进一步提高算法的效率。
    // 传统的 BFS 框架就是从起点开始向四周扩散，遇到终点时停止；
    // 而双向 BFS 则是从起点和终点同时开始扩散，当两边有交集的时候停止。
    class Solution2 {
        public int openLock(String[] deadends, String target) {
            Set<String> deads = new HashSet<>();
            for (String s : deadends)
                deads.add(s);
            // 不再使用队列，而是使用 HashSet 方便快速判断两个集合是否有交集。
            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> visited = new HashSet<>();

            int step = 0;
            q1.add("0000");
            q2.add(target);

            while (!q1.isEmpty() && !q2.isEmpty()) {
                // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
                Set<String> temp = new HashSet<>();

                /* 将 q1 中的所有节点向周围扩散 */
                for (String cur : q1) {
                    // 剪枝
                    if (deads.contains(cur))
                        continue;
                    // 判断是否到达终点
                    if (q2.contains(cur))
                        return step;

                    visited.add(cur);

                    /* 将一个节点的未遍历相邻节点加入集合 */
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up))
                            temp.add(up);
                        String down = minusOne(cur, j);
                        if (!visited.contains(down))
                            temp.add(down);
                    }
                }
                /* 在这里增加步数 */
                step++;
                // temp 相当于 q1
                // 这里交换 q1 q2，下一轮 while 就是扩散 q2
                q1 = q2;
                q2 = temp;
            }
            return -1;
        }
    }

    // 其实双向 BFS 还有一个优化，就是在 while 循环开始时做一个判断：
    // 因为按照 BFS 的逻辑，队列（集合）中的元素越多，扩散之后新的队列（集合）中的元素就越多；
    // 在双向 BFS 算法中，如果我们每次都选择一个较小的集合进行扩散，那么占用的空间增长速度就会慢一些，效率就会高一些。
    class Solution3 {
        int openLock(String[] deadends, String target) {
            Set<String> deads = new HashSet<>();
            for (String s : deadends) {
                deads.add(s);
            }

            // 用集合不用队列，可以快速判断元素是否存在
            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> visited = new HashSet<>();

            int step = 0;
            q1.add("0000");
            q2.add(target);

            while (!q1.isEmpty() && !q2.isEmpty()) {
                // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
                Set<String> temp = new HashSet<>();
                // 队列（集合）中的元素越多，扩散之后新的队列（集合）中的元素就越多；
                // 在双向 BFS 算法中，如果我们每次都选择一个较小的集合进行扩散，那么占用的空间增长速度就会慢一些，效率就会高一些。
                if (q1.size() > q2.size()) {
                    // 交换 q1 和 q2
                    temp = q1;
                    q1 = q2;
                    q2 = temp;
                }

                /* 将 q1 中的所有节点向周围扩散 */
                for (String cur : q1) {
                    // 剪枝
                    if (deads.contains(cur))
                        continue;
                    // 到达
                    if (q2.contains(cur))
                        return step;

                    visited.add(cur);

                    /* 将一个节点的未遍历相邻节点加入集合 */
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up))
                            temp.add(up);
                        String down = minusOne(cur, j);
                        if (!visited.contains(down))
                            temp.add(down);
                    }
                }
                /* 在这里增加步数 */
                step++;
                // temp 相当于 q1
                // 这里交换 q1 q2，下一轮 while 就是扩散 q2
                q1 = q2;
                q2 = temp;
            }
            return -1;
        }
    }
}
