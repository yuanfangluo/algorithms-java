package Algorithms.经典动态规划算法.贪心类型问题.老司机加油算法;

// https://leetcode.cn/problems/gas-station/
public class _134_加油站 {
    class Solution1 {
        int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            // 相当于图像中的坐标点和最低点
            int sum = 0, minSum = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                sum += gas[i] - cost[i];
                if (sum < minSum) {
                    // 经过第 i 个站点后，使 sum 到达新低
                    // 所以站点 i + 1 就是最低点（起点）
                    start = i + 1;
                    minSum = sum;
                }
            }
            if (sum < 0) {
                // 总油量小于总的消耗，无解
                return -1;
            }
            // 环形数组特性
            return start == n ? 0 : start;
        }
    }

    // 贪心解法
    class Solution2 {
        int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += gas[i] - cost[i];
            }

            if (sum < 0) {
                // 总油量小于总的消耗，无解
                return -1;
            }
            
            // 记录油箱中的油量
            int tank = 0;
            // 记录起点
            int start = 0;
            for (int i = 0; i < n; i++) {
                tank += gas[i] - cost[i];
                if (tank < 0) {
                    // 无法从 start 到达 i + 1
                    // 所以站点 i + 1 应该是起点
                    tank = 0;
                    start = i + 1;
                }
            }
            return start == n ? 0 : start;
        }
    }
}
