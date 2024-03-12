package LeetCode._4_回溯._6_子集_组合_元素无重可复选;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/combination-sum/
*
* */
public class _39_组合总和 {

//    这道题的关键在于 candidates 中的元素可以复用多次，体现在代码中是下面这段：
void backtrack1(int[] candidates, int start, int target, int sum) {
    // 可复选的回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i, target, sum); // 注意区别
        // 撤销选择 candidates[i]
    }
}

    //    对比 回溯算法团灭子集、排列、组合问题 中不能重复使用元素的标准组合问题：
    void backtrack2(int[] candidates, int start, int target, int sum) {
        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            backtrack2(candidates, i + 1, target, sum); // 注意区别
            // 撤销选择 candidates[i]
        }
    }

    // 这道题的解法如下
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] candidates, int start, int target, int sum) {
        //  base case
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            // 同一元素可重复使用，注意参数
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
