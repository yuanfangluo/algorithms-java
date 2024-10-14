package Algorithms._1_经典数据结构算法.手把手刷二叉树算法.二叉搜索树构造篇;

// https://leetcode.cn/problems/unique-binary-search-trees/
public class _96_不同的二叉搜索树 {

    // 所有元素都可以作为根节点

    // 备忘录
    int[][] memo;

    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo > hi)
            return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            //
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;
        return res;
    }
}
