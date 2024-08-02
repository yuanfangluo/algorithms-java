package Algorithms.核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.回溯;

public class 全排列 {
    // 回溯算法核心部分代码
    void backtrack(int[] nums) {
        // 回溯算法框架
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            used[i] = true;
            track.addLast(nums[i]);

            // 进入下一层回溯树
            backtrack(nums);

            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
