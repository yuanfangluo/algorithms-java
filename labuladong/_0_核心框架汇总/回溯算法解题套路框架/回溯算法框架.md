package Algorithms.核心框架汇总.回溯算法解题套路框架;

public class 回溯算法框架 {
    void backtrack(选择列表，路径) {
        if (满足结束条件) {
            result.add(路径);
            return;
        }

        for (选择 in 选择列表) {
            在这里做剪枝;
            做选择;
            backtrack(选择列表，路径);
            撤销选择;
        }
    }
}
