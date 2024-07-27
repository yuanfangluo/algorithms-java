package labuladong.其他常见算法技巧.经典面试题.一个方法解决三道区间问题;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/interval-list-intersections/
public class _986_区间列表的交集 {
    // 1. 首先找出两个区间不存在交集的情况
    // 2. 根据不存在交集的情况，找到交集的情况
    // 3. 找到指针前进的条件
    class Solution {
        // A, B 形如 [[0,2],[5,10]...]
        int[][] intervalIntersection(int[][] A, int[][] B) {
            // 双指针
            int i = 0, j = 0;
            List<int[]> res = new ArrayList<>();
            while (i < A.length && j < B.length) {
                int a1 = A[i][0], a2 = A[i][1];
                int b1 = B[j][0], b2 = B[j][1];
                // 两个区间存在交集
                if (b2 >= a1 && a2 >= b1) {
                    // 计算出交集，加入 res
                    res.add(new int[] { Math.max(a1, b1), Math.min(a2, b2) });
                }
                // 指针前进
                if (b2 < a2) {
                    j++;
                } else {
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
