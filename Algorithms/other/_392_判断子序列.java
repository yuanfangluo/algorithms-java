package Algorithms.other;

import java.util.ArrayList;

// https://leetcode.cn/problems/is-subsequence/
public class _392_判断子序列 {
    /*
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列
     */
    public boolean isSubsequence(String s, String t) {
        // 利用双指针 i, j 分别指向 s, t，一边前进一边匹配子序列
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // 如果给你一系列字符串 s1,s2,... 和字符串 t，你需要判定每个串 s 是否是 t 的子序列（可以假定 s 较短，t 很长）
    // 你也许会问，这不是很简单吗，还是刚才的逻辑，加个 for 循环不就行了？
    // 可以，但是此解法处理每个 s 时间复杂度仍然是 O(N)，而如果巧妙运用二分查找，可以将时间复杂度降低，大约是 O(MlogN)。
    // 由于 N 相对 M 大很多，所以后者效率会更高。

    // 二分思路
    boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        // 对 t 进行预处理
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (index[c] == null)
                index[c] = new ArrayList<>();
            index[c].add(i);
        }

        // 串 t 上的指针
        int j = 0;
        // 借助 index 查找 s[i]
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            // 整个 t 压根儿没有字符 c
            if (index[c] == null)
                return false;
            int pos = left_bound(index[c], j);
            // 二分搜索区间中没有找到字符 c
            if (pos == -1)
                return false;
            // 向前移动指针 j
            j = index[c].get(pos) + 1;
        }
        return true;
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
