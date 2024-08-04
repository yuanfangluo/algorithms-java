package Algorithms.核心框架汇总.学习算法和刷题的框架思维.框架;

import Algorithms.Base.Node;

public class 多叉树的遍历框架 {
    void traverse(Node root) {
        for (Node child : root.children)
            traverse(child);
    }
}