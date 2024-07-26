package labuladong.其他常见算法技巧.数学运用技巧.常用的位操作;

// https://leetcode.cn/problems/missing-number/
public class _268_丢失的数字 {
    // 现在有个等差数列 0, 1, 2,..., n，其中少了某一个数字，请你把它找出来。
    // 那这个数字不就是 sum(0,1,..n) - sum(nums) 嘛？
    class Solution1 {
        int missingNumber(int[] nums) {
            int n = nums.length;
            // 虽然题目给的数据范围不大，但严谨起见，用 long 类型防止整型溢出
            // 求和公式：(首项 + 末项) * 项数 / 2
            long expect = (0 + n) * (n + 1) / 2;
            long sum = 0;
            for (int x : nums) {
                sum += x;
            }
            return (int) (expect - sum);
        }
    }

    // 只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下
    class Solution2 {
        public int missingNumber(int[] nums) {
            // 新添加的索引n
            int n = nums.length;
            int res = 0;
            // 先和新补的索引异或一下
            res ^= n;
            // 和其他的元素、索引做异或
            for (int i = 0; i < n; i++)
                res ^= i ^ nums[i];
            return res;
        }
    }

}
