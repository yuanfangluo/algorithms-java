package Algorithms.经典数据结构算法.手把手刷数组算法.数组双指针经典题;


/*
* https://leetcode.cn/problems/sort-transformed-array/?show=1
*
* */
public class _360_有序转化数组 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // 双指针，相向而行，逼近对称轴
        int i = 0, j = nums.length - 1;
        // 如果开口朝上，越靠近对称轴函数值越小
        // 如果开口朝下，越靠近对称轴函数值越大
        int p = a > 0 ? nums.length - 1 : 0;
        int[] res = new int[nums.length];
        // 执行合并两个有序数组的逻辑
        while (i <= j) {
            int v1 = f(nums[i], a, b, c);
            int v2 = f(nums[j], a, b, c);
            if (a > 0) {
                // 如果开口朝上，越靠近对称轴函数值越小
                if (v1 > v2) {
                    res[p--] = v1;
                    i++;
                } else {
                    res[p--] = v2;
                    j--;
                }
            } else {
                // 如果开口朝下，越靠近对称轴函数值越大
                if (v1 > v2) {
                    res[p++] = v2;
                    j--;
                } else {
                    res[p++] = v1;
                    i++;
                }
            }
        }
        return res;
    }

    public int[] sortTransformedArray11(int[] nums, int a, int b, int c) {
        int n = nums.length, i = 0, j = n - 1;
        int[] res = new int[nums.length];
        int p = a > 0 ? n - 1 : 0;
        while (i <= j) {
            int v1 = f(nums[i], a, b, c);
            int v2 = f(nums[j], a, b, c);
            if (a > 0) {
                // 开口向上
                if (v1 > v2) {
                    res[p] = v1;
                    p--;
                    i++;
                } else {
                    res[p] = v2;
                    p--;
                    j--;
                }
            } else {
                if (v1 > v2) {
                    res[p] = v2;
                    p++;
                    j--;
                } else {
                    res[p] = v1;
                    p++;
                    i++;
                }
            }
        }
        return res;
    }

    int f(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}
