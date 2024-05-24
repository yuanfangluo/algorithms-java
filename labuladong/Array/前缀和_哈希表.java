package labuladong.Array;

import java.util.HashMap;

/*
*
* 前缀和数组帮你快速计算子数组的元素之和，但如果让你寻找某个符合条件的子数组，怎么办？
*
* 比方说，让你在 nums 中寻找和为 target 的子数组，就算有前缀和数组的帮助，你也要写个嵌套 for 循环：
*
* 但我们可以借助哈希表记录每个前缀和对应的索引，这样就能快速计算目标和为 target 的子数组了：
*
* */
public class 前缀和_哈希表 {

    void findSubArray(int[] nums, int target){
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 前缀和到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for (int j = 0; j < preSum.length; j++) {
            valToIndex.put(preSum[j], j);
        }

        for (int i = 1; i < preSum.length; i++) {
            int need = target - preSum[i];
            if (valToIndex.containsKey(need)) {
                // nums[valToIndex.get(need).. i] 就是和为 target 的子数组
            }
        }
    }

}
