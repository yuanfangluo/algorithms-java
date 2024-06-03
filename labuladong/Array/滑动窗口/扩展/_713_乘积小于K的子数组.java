package labuladong.Array.滑动窗口.扩展;

/*
* https://leetcode.cn/problems/subarray-product-less-than-k/?show=1
* 1. 什么时候扩大窗口？
* 乘积小于k的时候，扩大窗口，让乘积大一些
* 2. 什么时候缩小窗口？
* 乘积大于k的时候，缩小窗口，让乘积小一些
* 3. 什么时候得到一个合法的答案？
* 乘积小于k的时候，窗口内元素的所有子数组都是合法子数组
* */
public class _713_乘积小于K的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int left = 0, right = 0;
        // 滑动窗口，初始化为乘法单位元
        int windowProduct = 1;
        // 记录符合条件的子数组（窗口）个数
        int count = 0;

        while (right < nums.length) {
            // 扩大窗口
            windowProduct = windowProduct * nums[right];
            right++;

            while (left < right && windowProduct >= k) {
                // 缩小窗口
                windowProduct = windowProduct / nums[left];
                left++;
            }
            // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
            // 比方说 left = 1, right = 4 划定了[1, 4)这个窗口（right 是开区间）
            // 也就是[1, 2, 3] 
            // 但不止 [left..right)是合法的子数组，[left+1..right), [left+2..right) 等都是合法子数组
            // 所以我们需要记录 [1], [1,2], [1,2,3] 这 right - left 个子数组都加上

            count += right - left;
        }

        return count;
    }

}
