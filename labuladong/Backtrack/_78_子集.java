package labuladong.Backtrack;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/subsets/
*
* 输入：nums = [1,2,3]
* 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class _78_子集 {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /*
     * 回溯算法核心函数，遍历子集问题的回溯
     * 其中start来控制不能重复
     */
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 1.做选择
            track.addLast(nums[i]);

            // 2. 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);

            // 3. 撤销选择
            track.removeLast();
        }
    }

}
