package labuladong._1_经典数据结构算法.手把手刷数组算法.双指针技巧秒杀七道数组题目.左右指针.回文串判断;

/*
* https://leetcode.cn/problems/longest-palindromic-substring/
* 回文串就是正着读和反着读都一样的字符串
* */
public class _5_最长回文子串 {

    // 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
    // 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。

    String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 首先，需要在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    // 这样，如果输入相同的 l 和 r，就相当于寻找长度为奇数的回文串，
    // 如果输入相邻的 l 和 r，则相当于寻找长度为偶数的回文串。
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        
        // 注意这里的l已经-1了，r已经+1了
        // 而字符串的substring函数是包括beginIndex，不包括endIndex
        // 因此获取子串是substring(l + 1, r)
        return s.substring(l + 1, r);
    }
}
