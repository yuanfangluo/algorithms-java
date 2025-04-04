package labuladong._2_经典暴力搜索算法.BFS算法.如何用BFS算法秒杀各种智力题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/sliding-puzzle/
public class _773_滑动谜题 {
    // 如何穷举出 board 当前局面下可能衍生出的所有局面？
    class Solution {
        public int slidingPuzzle(int[][] board) {
            int m = 2, n = 3;
            StringBuilder sb = new StringBuilder();
            String target = "123450";
            // 将 2x3 的数组转化成字符串作为 BFS 的起点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
            }

            String start = sb.toString();

            // 下面都是索引
            // 012
            // 345
            // 012345
            
            // 索引0在2x3数组中相邻位置的索引：1，3
            // 索引1在2x3数组中相邻位置的索引：0，4，2
            // 索引2在2x3数组中相邻位置的索引：1，5
            // 索引3在2x3数组中相邻位置的索引：0，4
            // 索引4在2x3数组中相邻位置的索引：3，1，5
            // 索引5在2x3数组中相邻位置的索引：4，2
            int[][] neighbor = new int[][]{
                    {1, 3},
                    {0, 4, 2},
                    {1, 5},
                    {0, 4},
                    {3, 1, 5},
                    {4, 2}
            };
    
            /******* BFS 算法框架开始 *******/
            Queue<String> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            // 从起点开始 BFS 搜索
            q.offer(start);
            visited.add(start);
    
            int step = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    // 判断是否达到目标局面
                    if (target.equals(cur)) {
                        return step;
                    }
                    // 找到数字 0 的索引
                    int idx = 0;
                    for (; cur.charAt(idx) != '0'; idx++) ;
                    // 将数字 0 和相邻的数字交换位置
                    for (int adj : neighbor[idx]) {
                        String new_board = swap(cur.toCharArray(), adj, idx);
                        // 防止走回头路
                        if (!visited.contains(new_board)) {
                            q.offer(new_board);
                            visited.add(new_board);
                        }
                    }
                }
                step++;
            }
            /******* BFS 算法框架结束 *******/
            return -1;
        }
    
        private String swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            return new String(chars);
        }
    }
}
