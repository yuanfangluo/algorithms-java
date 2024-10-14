package Algorithms._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/group-anagrams/
public class _49_字母异位词分组 {

    // 异位词这类问题的关键在于，你如何迅速判断两个字符串是异位词，主要考察数据编码和哈希表的使用
    // 你是否可以找到一种编码方法，使得字母异位词的编码都相同？
    // 找到这种编码方式之后，就可以用一个哈希表存储编码相同的所有异位词，得到最终的答案。

    // 对字符串排序可以是一种编码方案，如果是异位词，排序后就变成一样的了，但是这样时间复杂度略高，且会修改原始数据。
    // 更好的编码方案是利用每个字符的出现次数进行编码，也就是下面的解法代码。
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 编码到分组的映射
            HashMap<String, List<String>> codeToGroup = new HashMap<>();
            for (String s : strs) {
                // 对字符串进行编码
                String code = encode(s);
                // 把编码相同的字符串放在一起
                codeToGroup.putIfAbsent(code, new LinkedList<>());
                codeToGroup.get(code).add(s);
            }

            // 获取结果
            List<List<String>> res = new LinkedList<>();
            for (List<String> group : codeToGroup.values()) {
                res.add(group);
            }
            return res;
        }

        // 利用每个字符的出现次数进行编码
        String encode(String s) {
            char[] count = new char[26];
            for (char c : s.toCharArray()) {
                int delta = c - 'a';
                count[delta]++;
            }
            System.out.println(new String(count));
            return new String(count);
        }
    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
