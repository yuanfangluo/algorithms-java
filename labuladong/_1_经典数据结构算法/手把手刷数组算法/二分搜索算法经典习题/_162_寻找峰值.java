package labuladong._1_经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;

/*
* https://leetcode.cn/problems/find-peak-element/?show=1
*
* 一般的二分搜索题目要根据 left, right 和 mid 的大小关系来判断到底应该搜索左侧还是右侧边界，
* 而这道题如果考察 left, right 和 mid 之间的相对大小会比较麻烦，你可能需要分很多种情况讨论，
* 比如 nums[mid] < nums[left] < nums[right]、nums[mid] > nums[left] > nums[right] 等等，写起来比较繁琐。
*
* 这道题更好的思路是不要考虑 left 和 right，单纯考虑 mid 周边的情况。
* 具体来说，我们计算 nums[mid] 和 nums[mid+1] 这两个元素的相对大小，即可得到 mid 附近的元素走势：
* 如果走势下行（nums[mid] > nums[mid+1]），说明 mid 本身就是峰值或其左侧有一个峰值，所以需要收缩右边界（right = mid）；
* 如果走势上行（nums[mid] < nums[mid+1]），则说明 mid 右侧有一个峰值，需要收缩左边界（left = mid + 1）。
* 因为题目说了 nums 中不存在相等的相邻元素，所以不用考虑 nums[mid] == nums[mid+1] 的情况，依据以上分析即可写出代码。
*
 * */
public class _162_寻找峰值 {

    // 峰值元素是指其值严格大于左右相邻值的元素
    public int findPeakElement(int[] nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.length - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
            }
        }
        return left;
    }

}
