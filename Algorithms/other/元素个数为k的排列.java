package Algorithms.other;

import java.util.LinkedList;
import java.util.List;

public class 元素个数为k的排列 {

    List<List<Integer>> res = new LinkedList<>();

    void backtrack(int[] nums, LinkedList<Integer> track, int k) {
        // 触发结束条件
        if (track.size() == k) { // 相当于在第k层的排列
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);

            // 进入下一层决策树
            backtrack(nums, track, k);

            // 取消选择
            track.removeLast();
        }
    }
}
