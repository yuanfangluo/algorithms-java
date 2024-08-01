package Algorithms.经典数据结构算法.手把手设计数据结构.栈的经典习题;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.cn/problems/longest-absolute-file-path/
public class _388_文件的最长绝对路径 {
    class Solution1 {

    }

    class Solution2 {
        // \n 和 \t 是一个字符
        // input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
        /*
         * dir
         * \t subdir1
         * \t subdir2
         * \t \t file.ext
         */

        public int lengthLongestPath(String input) {
            // 这个栈存储之前的父路径。实际上这里只用存父路径的长度就够了，这个优化留给你吧
            Deque<String> stack = new LinkedList<>();
            int maxLen = 0;
            for (String part : input.split("\n")) {
                // 计算当前路径的深度
                int level = part.lastIndexOf("\t") + 1;
                // 让栈中只保留当前目录的父路径
                while (level < stack.size()) {
                    stack.removeLast();
                }
                // 把当前目录的名字压入栈中
                stack.addLast(part.substring(level));
                // 走到这里代表当前目录是文件或者是最后一个目录
                // 如果是文件，就计算路径长度
                if (part.contains(".")) {
                    int sum = stack.stream().mapToInt(String::length).sum();
                    // 加上父路径的分隔符
                    sum += stack.size() - 1;

                    maxLen = Math.max(maxLen, sum);
                }
            }
            return maxLen;
        }
    }
}
