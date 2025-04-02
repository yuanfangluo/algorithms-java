package labuladong._0_核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.动态规划;

public class 斐波那契 {
    int fib(int N) {
        if (N == 1 || N == 2)
            return 1;
        return fib(N - 1) + fib(N - 2);
    }
}
