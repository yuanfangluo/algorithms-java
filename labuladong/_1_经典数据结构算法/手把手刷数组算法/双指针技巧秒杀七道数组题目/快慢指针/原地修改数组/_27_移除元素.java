package labuladong._1_经典数据结构算法.手把手刷数组算法.双指针技巧秒杀七道数组题目.快慢指针.原地修改数组;

// https://leetcode.cn/problems/remove-element/
public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
