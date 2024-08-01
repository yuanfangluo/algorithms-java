package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.HashSet;

// https://leetcode.cn/problems/fair-distribution-of-cookies/
// 这题和 1723. 完成所有工作的最短时间 是一模一样的
public class _2305_公平分发饼干 {
    class Solution {
        public int distributeCookies(int[] jobs, int k) {
            int[] workloads = new int[k];
            backtrack(jobs, 0, workloads);
            return res;
        }

        // 记录所有分配方案中的「最大工作时间」的最小值
        int res = Integer.MAX_VALUE;

        void backtrack(int[] jobs, int jobIdx, int[] workloads) {
            if (jobIdx == jobs.length) {
                // 找到一个分配方案
                // 计算当前分配方案下的最大工作时间
                int max = 0;
                for (int workload : workloads) {
                    max = Math.max(max, workload);
                }
                // 更新「所有分配方案中的最大工作时间」的最小值
                res = Math.min(res, max);
                return;
            }

            // 从当前的 jobs[jobIdx] 来选择工人
            // 注意，这个 chosen 是一个关键的剪枝优化，具体看我在思路部分的解释
            HashSet<Integer> chosen = new HashSet<>();
            for (int workreIdx = 0; workreIdx < workloads.length; workreIdx++) {
                if (workloads[workreIdx] + jobs[jobIdx] >= res) {
                    // 剪枝优化：如果当前工人的工作时间加上当前的工作时间已经超过了当前的最优解，那么就不用继续尝试了
                    continue;
                }
                if (chosen.contains(workloads[workreIdx])) {
                    // 剪枝优化：如果前面曾有工人有这个 workload，则不必把当前工作分配给他
                    continue;
                }

                // 做选择，将 jobs[jobIdx] 分配给工人 workreIdx
                chosen.add(workloads[workreIdx]);
                workloads[workreIdx] += jobs[jobIdx];
                backtrack(jobs, jobIdx + 1, workloads);
                // 撤销选择
                workloads[workreIdx] -= jobs[jobIdx];
            }
        }
    }
}
