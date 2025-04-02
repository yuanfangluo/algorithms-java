package labuladong._4_其他常见算法技巧.经典面试题.字符串乘法计算;

// https://leetcode.cn/problems/multiply-strings/
public class _43_字符串相乘 {
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();

            // 结果最多为 m + n 位数
            int[] res = new int[m + n];

            // 从个位数开始逐位相乘
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    // 乘积在 res 对应的索引位置
                    int p1 = i + j, p2 = i + j + 1;
                    // 叠加到 res 上
                    int sum = mul + res[p2];
                    res[p2] = sum % 10;
                    res[p1] += sum / 10;
                }
            }
            
            // 结果前缀可能存的 0（未使用的位）
            int i = 0;
            while (i < res.length && res[i] == 0)
                i++;

            // 将计算结果转化成字符串
            StringBuilder str = new StringBuilder();
            for (; i < res.length; i++)
                str.append(res[i]);
            
            return str.length() == 0 ? "0" : str.toString();
        }
    }
}
