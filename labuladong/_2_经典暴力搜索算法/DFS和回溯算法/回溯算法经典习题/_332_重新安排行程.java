package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/reconstruct-itinerary/
public class _332_重新安排行程 {
    class Solution1 {
        // 邻接表形式的图，key 是机场名字，value 是从该机场出发能够到达的机场列表
        Map<String, List<String>> graph = new HashMap<>();
        // 和 graph 对应，记录每张机票是否被使用过
        // 比如 graph["JFK"][2] = true 说明从机场 JFK 出发的第 3 张机票已经用过了
        Map<String, boolean[]> used = new HashMap<>();
        List<List<String>> tickets;

        // 回溯算法使用的数据结构
        LinkedList<String> track = new LinkedList<>();
        // 回溯算法记录结果
        List<String> res = null;

        public List<String> findItinerary(List<List<String>> tickets) {
            this.tickets = tickets;
            // 1. 用机场的名字构建邻接表
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if (!graph.containsKey(from)) {
                    graph.put(from, new ArrayList<>());
                }
                graph.get(from).add(to);
            }
            // 2. 对邻接表的每一行进行排序，保证字典序最小
            for (List<String> list : graph.values()) {
                Collections.sort(list);
            }
            // 3. 初始化 used 结构，初始值都为 false
            for (String key : graph.keySet()) {
                int size = graph.get(key).size();
                used.put(key, new boolean[size]);
            }
            // 4. 从起点 "JFK" 开始启动 DFS 算法递归遍历
            track.add("JFK");
            backtrack("JFK");
            return res;
        }

        void backtrack(String airport) {
            if (res != null) {
                // 已经找到答案了，不用再计算了
                return;
            }
            if (track.size() == tickets.size() + 1) {
                // track 里面包含了所有的机票，即得到了一个合法的结果
                // 注意 tickets.size() 要加一，因为 track 里面额外包含了起点 "JFK"
                res = new LinkedList<>(track);
                return;
            }
            if (!graph.containsKey(airport)) {
                // 没有从 s 出发的边
                return;
            }

            // 遍历当前机场所有能够到达的机场
            List<String> nextAirports = graph.get(airport);
            for (int nextIndex = 0; nextIndex < nextAirports.size(); nextIndex++) {
                String nextAirport = nextAirports.get(nextIndex);
                if (used.get(airport)[nextIndex]) {
                    // 如果这张机票被使用过，跳过
                    continue;
                }
                // 做选择
                used.get(airport)[nextIndex] = true;
                track.add(nextAirport);
                // 递归
                backtrack(nextAirport);
                // 撤销选择
                used.get(airport)[nextIndex] = false;
                track.removeLast();
            }
        }
    }

    class Solution2 {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        List<String> itinerary = new LinkedList<String>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if (!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<String>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String curr) {
            while (map.containsKey(curr) && map.get(curr).size() > 0) {
                String tmp = map.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }
    }

}
