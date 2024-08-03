package Algorithms._0_核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.回溯;

public class 回溯算法框架 {
   void backtrack(选择列表， 路径) {
       if (满足结束条件) {
           result.add(路径);
           return;
       }

       for (选择： 选择列表) {
           // 排除不合法的选择;
           做选择;
           backtrack(选择列表， 路径);
           撤销选择;
       }
   }
}
