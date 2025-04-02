package labuladong._0_核心框架汇总.学习算法和刷题的框架思维.习题;

import java.util.LinkedList;
import java.util.List;

public class 回溯算法之全排列算法 {
    List<List<Integer>> res = new LinkedList<>();

    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
