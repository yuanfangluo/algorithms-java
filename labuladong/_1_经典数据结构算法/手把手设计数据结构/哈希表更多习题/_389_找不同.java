package labuladong._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

// https://leetcode.cn/problems/find-the-difference/
public class _389_找不同 {
    // 这道题常规的思路是排序，两个字符串排序后，那个多出来的字符自然就很容易找到，
    // 但排序算法的时空复杂度都是 O(NlogN)，不是最优解法。

    // 哈希表计数，比较每个字符出现的次数，也很容易找到多出来的那个元素，时空复杂度都是 O(N)。
    // 注意由于题目说两个字符串只包含小写字母，所以用大小为 26 的字符数组就可以代替 HashMap 的作用，效率更高一些

    // 当然，最优的方法是用位运算，异或操作 ^ 的运算特点是 a ^ 0 = a, a ^ a = 0，
    // 即任何数字和 0 做异或的结果还是它本身，任何数字和它本身异或的结果是 0。

    // 字符其实就是数字，所以我们可以把这两个字符串中所有字符拿出来做异或操作，这样相同的两个数字都抵消为 0 了，最终剩下的就是多出来的那个数字。
    // 时间复杂度 O(N)，空间复杂度 O(1)。
    
    public static void main(String[] args) {
        System.out.println('a' ^ 'b');
    }
    

    // 位运算解法
    class Solution {

        public char findTheDifference(String s, String t) {
            int res = 0;
            for (char c : s.toCharArray()) {
                res = res ^ c;
            }
            for (char d : t.toCharArray()) {
                res = res ^ d;
            }

            // 根据异或运算规则，所有字符的异或结果就是多出来的那个字符
            return (char) res;
        }
    }

    // 哈希表计数的解法
    class Solution2 {
        public char findTheDifference(String s, String t) {
            int[] count1 = countChar(s);
            int[] count2 = countChar(t);

            for (int i = 0; i < count1.length; i++) {
                if (count1[i] != count2[i]) {
                    return (char) (i + 'a');
                }
            }
            return ' ';
        }

        // 计算字符的出现次数
        int[] countChar(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                // 把小写字母映射到 0~25 的区间
                int delta = c - 'a';
                count[delta]++;
            }
            return count;
        }
    }
}
