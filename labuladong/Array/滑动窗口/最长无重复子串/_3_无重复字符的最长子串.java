package labuladong.Array.滑动窗口.最长无重复子串;

import java.util.HashMap;

/*
* https://leetcode.cn/problems/longest-substring-without-repeating-characters/
* 1. 什么时候扩大窗口？
* 不包含重复字符串的时候
* 2. 什么时候缩小窗口？
* 包含重复字符串的时候
* 3. 什么时候得到一个合法的答案？
* 收缩窗口完成后更新 res，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复
* */
public class _3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = chars[right];
            right++;

            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = chars[left];
                left++;
                // 进行窗口内数据的一系列更
                window.put(d, window.get(d) - 1);
            }
            
            // 更新长度
            res = Math.max(res, right - left);
        }
        return res;
    }
}
