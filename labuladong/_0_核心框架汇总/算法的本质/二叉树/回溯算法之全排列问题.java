package labuladong._0_核心框架汇总.算法的本质.二叉树;

import java.util.LinkedList;
import java.util.List;

public class 回溯算法之全排列问题 {
    class Solution {

    // 记录所有全排列
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    // 回溯算法框架
    void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            // 穷举完一个全排列
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;
            // 前序遍历位置做选择
            track.add(nums[i]);
            backtrack(nums);
            // 后序遍历位置取消选择
            track.removeLast();
        }
    }
}
}
