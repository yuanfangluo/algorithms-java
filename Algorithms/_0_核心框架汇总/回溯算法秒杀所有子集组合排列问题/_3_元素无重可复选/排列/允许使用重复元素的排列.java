package Algorithms._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._3_元素无重可复选.排列;

import java.util.LinkedList;
import java.util.List;

public class 允许使用重复元素的排列 {
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> permuteRepeat(int[] nums) {
            backtrack(nums);
            return res;
        }

        // 回溯算法核心函数
        void backtrack(int[] nums) {
            // base case，到达叶子节点
            if (track.size() == nums.length) {
                // 收集叶子节点上的值
                res.add(new LinkedList(track));
                return;
            }

            // 回溯算法标准框架
            for (int i = 0; i < nums.length; i++) {
                // 做选择
                track.add(nums[i]);
                // 进入下一层回溯树
                backtrack(nums);
                // 取消选择
                track.removeLast();
            }
        }
    }
}
