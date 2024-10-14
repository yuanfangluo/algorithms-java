package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调队列的通用实现及经典习题.单调队列和动态规划;

import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.cn/problems/design-phone-directory/
public class _379_电话目录管理系统 {
    class PhoneDirectory {
        // 队列存储可用的号码
        private LinkedList<Integer> available = new LinkedList<>();
        // 集合存储已经使用的号码
        private HashSet<Integer> used = new HashSet<>();

        public PhoneDirectory(int maxNumbers) {
            for (int i = 0; i < maxNumbers; i++) {
                available.addLast(i);
            }
        }

        public int get() {
            if (available.isEmpty()) {
                return -1;
            }
            // 随意取出一个号码，并标记为已使用
            int number = available.removeLast();
            used.add(number);
            return number;
        }

        public boolean check(int number) {
            return !used.contains(number);
        }

        public void release(int number) {
            if (used.contains(number)) {
                used.remove(number);
                available.addLast(number);
            }
        }
    }

}
