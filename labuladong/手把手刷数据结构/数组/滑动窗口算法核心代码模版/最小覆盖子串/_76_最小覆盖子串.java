package labuladong.手把手刷数据结构.数组.滑动窗口算法核心代码模版.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.cn/problems/minimum-window-substring/
*
* 1. 什么时候扩大窗口？
* 2. 什么时候缩小窗口
* 3. 什么时候得到一个合理的答案？
* */
public class _76_最小覆盖子串 {

    /*
    * s是大串，t是小串
    * */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        // 1. 首先初始化两个哈希表
        // need记录需要凑齐的字符
        Map<Character, Integer> need = new HashMap();
        for (Character c: ts ) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // window记录窗口中的字符
        Map<Character, Integer> window = new HashMap();

        int left = 0, right = 0;
        // 表示window中某个字符的个数满足need中该字符的个数的这种情况的数量
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = ss[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                // 先对字符次数加一
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 再更新valid
                // Java 中的 Integer 和 String 这种包装类不能直接用 == 进行相等判断，而应该使用类的 equals 方法
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新结果：最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = ss[left];
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    // 先更新valid
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // 再对字符的次数减一
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
