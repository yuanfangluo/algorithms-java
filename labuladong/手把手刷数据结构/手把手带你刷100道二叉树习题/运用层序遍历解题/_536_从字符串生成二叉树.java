package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.Stack;

import LeetCode.LinkedList.LinkedList;
import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-string/
public class _536_从字符串生成二叉树 {
    // 这题就是考察用栈模拟递归构造二叉树的过程。

    // 注意除了根节点之外的每个节点都对应一对括号，所以可以根据有括号来判断一个节点是否完成组装。
    class Solution {
        public TreeNode str2tree(String s) {
            if (s.isEmpty()) {
                return null;
            }

            // 用栈模拟递归建树过程
            Stack<TreeNode> stk = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    continue;
                }
                if (s.charAt(i) == ')') {
                    // 每次遇到有括号，都说明栈顶节点构建完成
                    stk.pop();
                    continue;
                }

                // 开始读取数字
                int j = i;
                int num = 0, sign = 1;
                if (s.charAt(j) == '-') {
                    sign = -1;
                    j++;
                }

                while (j < s.length()
                        && s.charAt(j) <= '9' && s.charAt(j) >= '0') {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                
                i = j - 1;
                num = num * sign;
                // 数字读取完成

                // 新建节点
                TreeNode node = new TreeNode(num);
                if (!stk.isEmpty()) {
                    // 栈顶元素永远是当前处理节点的父节点
                    TreeNode parent = stk.peek();
                    // 根据父节点的左右子节点情况组装
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                // 新节点入栈
                stk.push(node);
            }
            // 注意到除了整棵树的根节点之外，
            // 其他的每个节点都可以找到一个有括号配对，
            // 所以最后栈中一定还有一个节点，就是根节点
            return stk.peek();
        }
    }

}
