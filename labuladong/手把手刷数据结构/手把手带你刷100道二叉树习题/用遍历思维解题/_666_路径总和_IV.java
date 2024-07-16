package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.用遍历思维解题;

import static java.lang.StringTemplate.STR;

import java.util.HashMap;

// https://leetcode.cn/problems/path-sum-iv/
public class _666_路径总和_IV {
    // 具体来说就是，这里我们无法用常规的 left, right 指针来遍历左右子节点，但是可以通过父节点的编号计算出子节点的编号，从而确定子节点。

    // 在这道题中，假设父节点在行中的编号为 x，则左子节点为下一行的 2 * x - 1，右子节点为下一行的 2 * x。

    // 记录所有路径和
    int sum = 0;

    HashMap<Integer, Integer> tree = new HashMap<>();

    public int pathSum(int[] nums) {
        // 记录节点编码到值的映射
        for (int code : nums) {
            int value = code % 10;
            code = code / 10;
            tree.put(code, value);
        }

        // 输入已经排序，第一个就是根节点
        int rootCode = nums[0] / 10;

        // 遍历二叉树求所有路径总和
        traverse(rootCode, 0);

        return sum;
    }

    // 将 (depth, id) 编码为十进制两位数
    int encode(int depth, int id) {
        return 10 * depth + id;
    }

    // 解码出 (depth, id)
    int[] decode(int code) {
        return new int[] { code / 10, code % 10 };
    }

    // 二叉树遍历函数，顺便记录遍历过的路径之和
    void traverse(int code, int path) {
        if (!tree.containsKey(code)) {
            return;
        }
        // 当前遍历到的节点值
        int value = tree.get(code);
        int[] pos = decode(code);
        // 当前遍历到的节点深度和 id
        int depth = pos[0], id = pos[1];

        // 左右子节点的编码
        int leftCode = encode(depth + 1, id * 2 - 1);
        int rightCode = encode(depth + 1, id * 2);
        if (!tree.containsKey(leftCode) && !tree.containsKey(rightCode)) {
            sum += path + value;
            return;
        }

        // 二叉树遍历框架
        traverse(leftCode, path + value);
        traverse(rightCode, path + value);

    }
    
    class Solution {
        public int pathSum(int[] nums) {
            Integer[][] val = new Integer[5][9];
            for (int i : nums) {
                val[i / 100 % 10][i / 10 % 10] = i % 10;
            }
            return dfs(val, 1, 1, 0);
        }
    
        private int dfs(Integer[][] val, int i, int j, int sum) {
            if (null == val[i][j]) {
                return 0;
            }
            sum += val[i][j];
            if (i >= val.length - 1 || null == val[i + 1][j * 2 - 1] && null == val[i + 1][j * 2]) {
                return sum;
            }
            return dfs(val, i + 1, j * 2 - 1, sum) + dfs(val, i + 1, j * 2, sum);
        }
    }

}
