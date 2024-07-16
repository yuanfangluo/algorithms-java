package labuladong.手把手刷数据结构.手把手刷数组算法.双指针技巧秒杀七道数组题目.左右指针.反转数组;

/*
* https://leetcode.cn/problems/reverse-string/description/
*
* */
public class _344_反转字符串 {

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

    public void reverseString11(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

}
