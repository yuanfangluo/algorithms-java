package labuladong.Array.滑动窗口.找所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* https://leetcode.cn/problems/find-all-anagrams-in-a-string/
* 1. 什么时候扩大窗口？
* 2. 什么时候缩小窗口？
* 3. 什么时候得到一个合适的答案？
* */
public class _438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String t) {

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        HashMap<Character, Integer> need = new HashMap();
        HashMap<Character, Integer> window = new HashMap();

        for (Character c: ts ) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList();
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = ss[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // Java 中的 Integer 和 String 这种包装类不能直接用 == 进行相等判断，而应该使用类的 equals 方法
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while ((right - left) >= t.length()) {
                // 在这里符合条件，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }

                // d 是将移出窗口的字符
                char d = ss[left];
                // 左移窗口
                left++;
                
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

}
