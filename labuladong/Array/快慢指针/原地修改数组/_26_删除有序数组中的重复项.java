package labuladong.Array.快慢指针.原地修改数组;

/*
* https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
*
* */
public class _26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
