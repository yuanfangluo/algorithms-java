// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
public class _718_最长重复子数组 {
    // 最长重复子数组
    // 给你两个整数数组 nums1 和 nums2 ，请你找出并返回这两个正序数组的 最长公共子数组的长度 。
    // 子数组 是由原数组中删除一些元素（也可以不删除）而组成的一个新数组。
    // 例如，[1,3,2,1] 是 [1,2,3,4,1] 的一个子数组。
    // 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    // 输出：3
    // 解释：长度最长的公共子数组是 [3,2,1] 。
    // 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    // 输出：5
    // 提示：
    // 1 <= nums1.length, nums2.length <= 1000
    // 0 <= nums1[i], nums2[i] <= 100
    // 链接：URL_ADDRESS
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 2, 1 };
        int[] nums2 = { 3, 2, 1, 4, 7 };
        System.out.println(new _718_最长重复子数组().findLength(nums1, nums2));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 定义dp数组
        // dp[i][j]表示nums1[0...i-1]和nums2[0...j-1]的最长公共子数组的长度
        // 状态转移方程：dp[i][j] = dp[i-1][j-1] + 1 if nums1[i-1] == nums2[j-1] else 0
        // 初始化dp数组        
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
