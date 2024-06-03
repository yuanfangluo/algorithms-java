package labuladong.Array.原地修改数组;

/*
* https://leetcode.cn/problems/remove-element/
*
* */
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
