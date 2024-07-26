package labuladong.经典数据结构算法.手把手刷数组算法.双指针技巧秒杀七道数组题目.左右指针.回文串判断;

public class 回文串判断 {
    boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
