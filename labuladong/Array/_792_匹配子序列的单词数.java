package labuladong.Array;

import java.util.ArrayList;

/*
* https://leetcode.cn/problems/number-of-matching-subsequences/
*
* */
public class _792_匹配子序列的单词数 {

    public static void main(String[] args) {
        System.out.println(
                new _792_匹配子序列的单词数().numMatchingSubseq("zabcde", new String[]{"a","bb","acd","ace"})
        );
    }

    int numMatchingSubseq(String s, String[] words) {
        // 对 s 进行预处理
        // char -> 该 char 的索引列表
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        int res = 0;
        for (String word : words) {
            // 字符串 word 上的指针
            int i = 0;
            // 串 s 上的指针
            int j = 0;
            // 借助 index 查找 word 中每个字符的索引
            for (; i < word.length(); i++) {
                char c = word.charAt(i);
                // 整个 s 压根儿没有字符 c
                if (index[c] == null) {
                    break;
                }
                int pos = left_bound(index[c], j);
                // 二分搜索区间中没有找到字符 c
                if (pos == -1) {
                    break;
                }
                // 向前移动指针 j
                j = index[c].get(pos) + 1;
            }
            // 如果 word 完成匹配，则是子序列
            if (i == word.length()) {
                res++;
            }
        }

        return res;
    }

    // 查找左侧边界的二分查找
    int left_bound(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == arr.size()) {
            return -1;
        }
        return left;
    }

}
