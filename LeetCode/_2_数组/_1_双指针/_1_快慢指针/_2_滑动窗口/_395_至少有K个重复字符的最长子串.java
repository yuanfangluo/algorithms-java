package LeetCode._2_数组._1_双指针._1_快慢指针._2_滑动窗口;

/*
* https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/?show=1
* 1. 什么时候扩大窗口？
* 窗口中字符种类小于count
* 2. 什么时候缩小窗口？
* 窗口中字符种类大于count
* 3. 什么时候得到一个合法的答案？
* 窗口中字符出现的次数大于等于k
*
* 在本题的场景中，我们想尽可能多地装字符，即扩大窗口，但不知道什么时候应该开始收缩窗口。
* 为什么呢？比如窗口中有些字符出现次数不满足 k，但有可能再扩大扩大窗口就能满足 k 了呀？
* 但要这么说的话，你干脆一直扩大窗口算了，所以你说不准啥时候应该收缩窗口。
*
* 理论上讲，这种情况就不能用滑动窗口模板了，但有时候我们可以自己添加一些约束，来进行窗口的收缩。
*
* 题目说让我们求每个字符都出现至少 k 次的子串，我们可以再添加一个约束条件：
* 求每个字符都出现至少 k 次，仅包含 count 种不同字符的最长子串。
* // 在 s 中寻找仅含有 count 种字符，且每种字符出现次数都大于 k 的最长子串
* int logestKLetterSubstr(String s, int k, int count)
*
* 当然，题目没有 count 的约束，那没关系呀，count 能有几种取值？
* 因为 s 中只包含小写字母，所以 count 的取值也就是 1~26，所以最后用一个 for 循环把这些值都输入 logestKLetterSubstr 计算一遍，求最大值就是题目想要的答案了。
* 这充分体现了前文 我的刷题经验总结 中所说：算法的本质是穷举。
* 滑动窗口算法的时间复杂度是 O(N)，循环 26 次依然是 O(26N) = O(N)。
*
 * */
public class _395_至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int len = 0;
        for (int i = 1; i <= 26; i++) {
            // 限制窗口中只能有 i 种不同字符
            len = Math.max(len, logestKLetterSubstr(s, k, i));
        }
        return len;
    }

    // 寻找 s 中含有 count 种字符，且每种字符出现次数都大于 k 的子串
    int logestKLetterSubstr(String s, int k, int count) {
        // 记录答案
        int res = 0;
        // 快慢指针维护滑动窗口，左闭右开区间
        int left = 0, right = 0;
        // 题目说 s 中只有小写字母，所以用大小 26 的数组记录窗口中字符出现的次数
        int[] windowCount = new int[26];
        // 记录窗口中存在几种不同的字符（字符种类）
        int windowUniqueCount = 0;
        // 记录窗口中有几种字符的出现次数达标（大于等于 k）
        int windowValidCount = 0;
        // 滑动窗口代码模板
        while (right < s.length()) {
            // 移入字符，扩大窗口
            char c = s.charAt(right);
            if (windowCount[c - 'a'] == 0) {
                // 窗口中新增了一种字符
                windowUniqueCount++;
            }
            windowCount[c - 'a']++;
            if (windowCount[c - 'a'] == k) {
                // 窗口中新增了一种达标的字符
                windowValidCount++;
            }
            right++;

            // 当窗口中字符种类大于 k 时，缩小窗口
            while (windowUniqueCount > count) {
                // 移出字符，缩小窗口
                char d = s.charAt(left);
                if (windowCount[d - 'a'] == k) {
                    // 窗口中减少了一种达标的字符
                    windowValidCount--;
                }
                windowCount[d - 'a']--;
                if (windowCount[d - 'a'] == 0) {
                    // 窗口中减少了一种字符
                    windowUniqueCount--;
                }
                left++;
            }

            // 当窗口中字符种类为 count 且每个字符出现次数都满足 k 时，更新答案
            if (windowValidCount == count) {
                res = Math.max(res, right - left);
            }
        }
        return res;
    }

}
