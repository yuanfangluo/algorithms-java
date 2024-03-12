package LeetCode._4_回溯.总结;

import java.util.LinkedList;
import java.util.List;

public class _1_元素无重不可复选 {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    /* 组合/子集问题回溯算法框架 */
    void backtrack1(int[] nums, int start) {
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 注意参数
            backtrack1(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }


    /* 排列问题回溯算法框架 */
    boolean[] used;
    void backtrack2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 剪枝逻辑
            if (used[i]) {
                continue;
            }
            // 做选择
            used[i] = true;
            track.addLast(nums[i]);

            backtrack2(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

}
