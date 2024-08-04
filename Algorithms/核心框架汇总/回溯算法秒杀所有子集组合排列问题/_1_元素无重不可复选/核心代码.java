package Algorithms.核心框架汇总.回溯算法秒杀所有子集组合排列问题._1_元素无重不可复选;

public class 核心代码 {
    /* 组合/子集问题回溯算法框架 */
    void backtrack(int[] nums, int start) {
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 注意参数
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    /* 排列问题回溯算法框架 */
    void backtrack(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 剪枝逻辑
            if (used[i]) {
                continue;
            }
            // 做选择
            used[i] = true;
            track.addLast(nums[i]);

            backtrack(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
