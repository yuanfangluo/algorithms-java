package labuladong._4_其他常见算法技巧.数学运用技巧.如何同时寻找缺失和重复的元素;

// https://leetcode.cn/problems/set-mismatch/
public class _645_错误的集合 {
    // 关键点在于元素和索引是成对儿出现的，常用的方法是排序、异或、映射。
    // 映射的思路就是我们刚才的分析，将每个索引和元素映射起来，通过正负号记录某个元素是否被映射。

    int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;

        return new int[] { dup, missing };
    }
}
