package LeetCode._2_数组._1_双指针._1_快慢指针._2_滑动窗口;

/*
* https://leetcode.cn/problems/max-consecutive-ones-iii/?show=1
*
* */
public class _1004_最大连续1的个数_III {

    public int longestOnes(int[] nums, int k) {

        // 记录窗口中 1 的次数
        int windowOneCount = 0;
        int left = 0, right = 0;
        // 记录结果长度
        int res = 0;
        while (right < nums.length) {
            int c = nums[right];
            if (c == 1) {
                windowOneCount++;
            }
            right++;

            // 判断左侧窗口是否要收缩
            while ((right - left - windowOneCount) > k) { // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
                int d = nums[left];

                if (d == 1) {
                    windowOneCount--;
                }

                left++;
            }
            // 此时一定是一个合法的窗口
            res = Math.max(res, right - left);
        }
        return res;
    }


}
