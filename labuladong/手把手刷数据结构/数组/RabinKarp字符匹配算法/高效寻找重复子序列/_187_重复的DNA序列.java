package labuladong.手把手刷数据结构.数组.RabinKarp字符匹配算法.高效寻找重复子序列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/repeated-dna-sequences/
public class _187_重复的DNA序列 {

    // 使用substring截取字符串
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        // 记录出现过的子串
        HashSet<String> seen = new HashSet<>();
        // 记录那些重复出现多次的子串
        // 注意要用哈希集合，防止记录重复的结果
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i + 10 <= n; i++) {
            String subStr = s.substring(i, i + 10);
            if (seen.contains(subStr)) {
                // 之前出现过，找到一个重复的
                res.add(subStr);
            } else {
                // 之前没出现过，加入集合
                seen.add(subStr);
            }
        }
        return new LinkedList<>(res);
    }

    // 而且窗口移动的过程，其实就是给这个数字的最低位添加数字，并删除最高位数字的过程
    // AGCT 四种字符等价为 0123 四个数字，那么长度为 L = 10 的一个碱基序列其实就可以等价为一个十位数，这个数字可以唯一标识一个子串。
    // 其实你想下，你把一个字符串对象转化成了一个数字，这是什么？
    // 这就是你设计的一个哈希算法，生成的数字就可以认为是字符串的哈希值。
    public List<String> findRepeatedDnaSequences2(String s) {
        // 先把字符串转化成四进制的数字数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        
        // 记录重复出现的哈希值
        HashSet<Integer> seen = new HashSet<>();
        // 记录重复出现的字符串结果
        HashSet<String> res = new HashSet<>();

        // 数字位数
        int L = 10;
        // 进制
        int R = 4;
        // 存储 R^(L - 1) 的结果
        int RL = (int) Math.pow(R, L - 1);
        // 维护滑动窗口中字符串的哈希值
        int windowHash = 0;

        // 滑动窗口代码框架，时间 O(N)
        int left = 0, right = 0;
        while (right < nums.length) {
            // 扩大窗口，移入字符，并维护窗口哈希值（在最低位添加数字）
            windowHash = R * windowHash + nums[right];
            right++;

            // 当子串的长度达到要求
            if (right - left == L) {
                // 根据哈希值判断是否曾经出现过相同的子串
                if (seen.contains(windowHash)) {
                    // 当前窗口中的子串是重复出现的
                    res.add(s.substring(left, right));
                } else {
                    // 当前窗口中的子串之前没有出现过，记下来
                    seen.add(windowHash);
                }
                // 缩小窗口，移出字符，并维护窗口哈希值（删除最高位数字）
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }
        // 转化成题目要求的 List 类型
        return new LinkedList<>(res);

    }
}
