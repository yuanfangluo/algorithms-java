package Algorithms._4_其他常见算法技巧.经典面试题.一文秒杀所有丑数系列问题;

// https://leetcode.cn/problems/ugly-number-iii/?show=1

public class _1201_丑数_III {
    // 方法一：用合并单链表的思路（超时）
    class Solution1 {
        public int nthUglyNumber(int n, int a, int b, int c) {
            // 可以理解为三个有序链表的头结点的值
            long productA = a, productB = b, productC = c;
            // 可以理解为合并之后的有序链表上的指针
            int p = 1;
            long min = -666;
            // 开始合并三个有序链表，获取第 n 个节点的值
            while (p <= n) {
                // 取三个链表的最小结点
                min = Math.min(Math.min(productA, productB), productC);
                p++;
                // 前进最小结点对应链表的指针
                if (min == productA) {
                    productA += a;
                }
                if (min == productB) {
                    productB += b;
                }
                if (min == productC) {
                    productC += c;
                }
            }
            return (int) min;
        }
    }

    class Solution2 {
        // 方法一：二分搜索 + 数学解法
        public int nthUglyNumber(int n, int a, int b, int c) {
            // 题目说本题结果在 [1, 2 * 10^9] 范围内，
            // 所以就按照这个范围初始化两端都闭的搜索区间
            int left = 1, right = (int) 2e9;
            // 搜索左侧边界的二分搜索
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (f(mid, a, b, c) < n) {
                    // [1..mid] 中的元素个数不足 n，所以目标在右侧
                    left = mid + 1;
                } else {
                    // [1..mid] 中的元素个数大于 n，所以目标在左侧
                    right = mid - 1;
                }
            }
            return left;
        }

        // 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
        long f(int num, int a, int b, int c) {
            long setA = num / a, setB = num / b, setC = num / c;
            long setAB = num / lcm(a, b);
            long setAC = num / lcm(a, c);
            long setBC = num / lcm(b, c);
            long setABC = num / lcm(lcm(a, b), c);
            // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
            return setA + setB + setC - setAB - setAC - setBC + setABC;
        }

        // 最小公倍数
        long lcm(long a, long b) {
            // 最小公倍数就是乘积除以最大公因数
            return a * b / gcd(a, b);
        }
        
        // 计算最大公因数（辗转相除/欧几里得算法）
        long gcd(long a, long b) {
            if (a < b) {
                // 保证 a > b
                return gcd(b, a);
            }
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }

}
