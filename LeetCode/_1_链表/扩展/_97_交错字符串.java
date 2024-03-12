package LeetCode._1_链表.扩展;

import java.util.Arrays;

/*
* https://leetcode.cn/problems/interleaving-string/?show=1
*
* 如果你看过前文 单链表六大解题套路 中讲解的 21. 合并两个有序链表 就会发现，
* 题目巴拉巴拉说了一大堆，实则就是一个使用双指针技巧合并两个字符串的过程
*
* 肯定需要一个递归函数来穷举双指针的匹配过程，然后用一个备忘录消除递归过程中的重叠子问题，
* 也就能写出自顶向下的递归的动态规划解法了
* */
public class _97_交错字符串 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        // 如果长度对不上，必然不可能
        if (m + n != s3.length()) {
            return false;
        }

        // 备忘录，其中 -1 代表未计算，0 代表 false，1 代表 true
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0, s3);
    }

    int[][] memo;

    // 定义：计算 s1[i..] 和 s2[j..] 是否能组合出 s3[i+j..]
    boolean dp(String s1, int i, String s2, int j, String s3) {
        int k = i + j;
        // base case，s3 构造完成
        if (k == s3.length()) {
            return true;
        }
        // 查备忘录，如果已经计算过，直接返回
        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? true : false;
        }

        boolean res = false;
        // 如果，s1[i] 可以匹配 s3[k]，那么填入 s1[i] 试一下
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dp(s1, i + 1, s2, j, s3);
        }
        // 如果，s1[i] 匹配不了，s2[j] 可以匹配，那么填入 s2[j] 试一下
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || dp(s1, i, s2, j + 1, s3);
        }
        // 如果 s1[i] 和 s2[j] 都匹配不了，则返回 false
        // 将结果存入备忘录
        memo[i][j] = res == true ? 1 : 0;

        return res;
    }
}
