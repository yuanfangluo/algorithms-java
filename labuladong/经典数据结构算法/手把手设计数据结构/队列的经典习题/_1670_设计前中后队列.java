package labuladong.经典数据结构算法.手把手设计数据结构.队列的经典习题;

import java.util.LinkedList;

// https://leetcode.cn/problems/design-front-middle-back-queue/
public class _1670_设计前中后队列 {
    class FrontMiddleBackQueue {
        // 用两个列表表示队列的左右两部分，一遍从中间操作元素
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        // 如果是奇数个元素，维护左边少右边多，所以：
        // 1、如果有偶数个元素时，pushMiddle 优先向右边添加
        // 2、如果有奇数个元素时，popMiddle 优先从右边删除
        // 3、如果只有 1 个元素，popFront 的时候，要去右边删除
        // 要把以上三个特点写到代码里，才能保证细节不出错

        // 维护左边少右边多的状态，每次增删元素之后都要执行一次
        private void balance() {
            // 右边最多比左边多一个元素
            if (right.size() > left.size() + 1) {
                // 右边多，匀一个给左边
                left.addLast(right.removeFirst());
            }
            if (left.size() > right.size()) {
                // 左边多，匀一个给右边
                right.addFirst(left.removeLast());
            }
        }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (size() % 2 == 0) {
                // 如果有偶数个元素时，pushMiddle 优先向右边添加
                right.addFirst(val);
            } else {
                left.addLast(val);
            }
            balance();
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (size() == 0) {
                return -1;
            }
            if (size() == 1) {
                // 如果只有 1 个元素，popFront 的时候，要去右边删除
                return right.removeFirst();
            }
            int e = left.removeFirst();
            balance();
            return e;
        }

        public int popMiddle() {
            if (size() == 0) {
                return -1;
            }
            int e;
            if (size() % 2 == 0) {
                e = left.removeLast();
            } else {
                // 如果有奇数个元素时，popMiddle 优先从右边删除
                e = right.removeFirst();
            }
            balance();
            return e;
        }

        public int popBack() {
            if (size() == 0) {
                return -1;
            }
            int e = right.removeLast();
            balance();
            return e;
        }

        public int size() {
            return left.size() + right.size();
        }
    }
}
