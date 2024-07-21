package labuladong.other;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/combinations/
*
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
public class _77_组合 {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 组合
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    /*
     * start ：控制不重复
     * n ： 可选项
     * k ： 个数
     */
    void backtrack(int start, int n, int k) {
        // base case。结束条件
        if (k == track.size()) {
            // 遍历到了第 k 层，收集当前节点的值
            res.add(new LinkedList<>(track));
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1, n, k);
            // 撤销选择
            track.removeLast();
        }
    }
}
