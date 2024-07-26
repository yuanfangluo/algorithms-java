package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/
public class _1723_完成所有工作的最短时间 {
    // 从 job 的视角来选择员工
    // 将数组分成k组，求所有分组的和的最小值
    class Solution1 {
        public int minimumTimeRequired(int[] jobs, int k) {
            // workloads[i] 表示第 i 个工人的当前已经被分配的工作量
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
            for (int workerIdx = 0; workerIdx < workloads.length; workerIdx++) {
                if (workloads[workerIdx] + jobs[jobIdx] >= res) {
                    // 剪枝优化：如果当前工人的工作时间加上当前的工作时间已经超过了当前的最优解，那么就不用继续尝试了
                    continue;
                }
                if (chosen.contains(workloads[workerIdx])) {
                    // 剪枝优化：如果前面曾有工人有这个 workload，则不必把当前工作分配给他
                    continue;
                }

                // 做选择，将 jobs[jobIdx] 分配给工人 workreIdx
                chosen.add(workloads[workerIdx]);
                workloads[workerIdx] += jobs[jobIdx];
                backtrack(jobs, jobIdx + 1, workloads);
                // 撤销选择
                workloads[workerIdx] -= jobs[jobIdx];
            }
        }
    }

    class Solution2 {
        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            int low = 0, high = jobs.length - 1;
            while (low < high) {
                int temp = jobs[low];
                jobs[low] = jobs[high];
                jobs[high] = temp;
                low++;
                high--;
            }
            int l = jobs[0], r = Arrays.stream(jobs).sum();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (check(jobs, k, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
        // 检查当前限制下是否能完成所有工作
        public boolean check(int[] jobs, int k, int limit) {
            int[] workloads = new int[k];
            return backtrack(jobs, workloads, 0, limit);
        }

        public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
            if (i >= jobs.length) {
                return true;
            }
            int cur = jobs[i];
            for (int j = 0; j < workloads.length; ++j) {
                if (workloads[j] + cur <= limit) {
                    workloads[j] += cur;
                    if (backtrack(jobs, workloads, i + 1, limit)) {
                        return true;
                    }
                    workloads[j] -= cur;
                }
                // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
                // 或者当前工作恰能使该工人的工作量达到了上限
                // 这两种情况下我们无需尝试继续分配工作
                if (workloads[j] == 0 || workloads[j] + cur == limit) {
                    break;
                }
            }
            return false;
        }
    }
}
