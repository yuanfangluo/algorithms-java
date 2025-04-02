package labuladong._0_核心框架汇总.双指针技巧秒杀七道数组题目.左右指针.反转数组;

// https://leetcode.cn/problems/reverse-string/description/
public class _344_反转字符串 {
    class Solution {
        public void reverseString(char[] s) {
            // 一左一右两个指针相向而行
            int left = 0, right = s.length - 1;
            while (left < right) {
                // 交换 s[left] 和 s[right]
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
}
