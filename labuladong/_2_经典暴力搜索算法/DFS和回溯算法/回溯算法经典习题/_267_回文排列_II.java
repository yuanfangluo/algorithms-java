package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-permutation-ii/
public class _267_回文排列_II {
    // 1、首先，我们要判断一个字符串是否能够构成回文串。
    // 2、如果存在出现奇数次的中心字符，我们先把这个中心字符拿出来，留到最后特殊处理。
    // 3、经过上一步的处理，所有字符出现的次数都是偶数次，把这个字符串字符出现的次数除以二。
    // 4、接下来，我们要找到这个字符串的全排列。
    // 注意此时的字符串可能存在重复，所以需要执行带去重的全排列算法
    // 元素可重不可复选 的全排列算法
    // 5、最后，我们把每个全排列的结果进行镜像对称，再插入中心字符（如果存在），就得到了所有可能的回文串。

    class Solution {
        public List<String> generatePalindromes(String s) {
            // 统计字符出现次数，只有小写字符，用数组即可
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // 回文串，最多只能有一个字符出现奇数次
            int oddCount = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 == 1) {
                    oddCount++;
                }
                if (oddCount > 1) {
                    // 无法构成回文串
                    return new ArrayList<>();
                }
            }

            // 找到回文串的中心字符
            char center = ' ';
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 == 1) {
                    center = (char) (i + 'a');
                    count[i]--;
                    break;
                }
            }

            // 构造回文串的一半
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    sb.append((char) (i + 'a'));
                }
            }

            // 执行元素可重不可复选的全排列算法
            permuteUnique(sb.toString());

            // 拼接回文结果
            List<String> result = new ArrayList<>();
            for (String left : res) {
                String right = new StringBuilder(left).reverse().toString();
                if (center != ' ') {
                    left += center;
                }
                result.add(left + right);
            }
            return result;
        }

        // 下面的代码是我直接从前文《一文秒杀排列组合子集问题的 9 种变体》 copy 过来的，
        // 就不做过多解释了，如果有疑问请查看前文：
        // https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/

        List<String> res = new LinkedList<>();
        LinkedList<Character> track = new LinkedList<>();
        boolean[] used;

        public List<String> permuteUnique(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            used = new boolean[chars.length];
            backtrack(chars);
            return res;
        }

        void backtrack(char[] chars) {
            if (track.size() == chars.length) {
                StringBuilder sb = new StringBuilder();
                for (char c : track) {
                    sb.append(c);
                }
                res.add(sb.toString());
                return;
            }

            for (int i = 0; i < chars.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }

                track.add(chars[i]);
                used[i] = true;
                backtrack(chars);
                track.removeLast();
                used[i] = false;
            }
        }

    }
}
