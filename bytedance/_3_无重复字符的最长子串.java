import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

public class _3_无重复字符的最长子串 {
    // 滑动窗口
    // 左闭右开
    // window的长度为right - left
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更
                    window.put(d, window.get(d) - 1);
                }
                // 到这里代表窗口的字符个数都是1
                // 更新长度
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
