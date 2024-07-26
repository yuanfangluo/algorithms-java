package labuladong.经典数据结构算法.手把手设计数据结构.用队列实现栈和用栈实现队列;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
public class _225_用队列实现栈 {
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int top_elem = 0;

        /**
         * 添加元素到栈顶
         */
        public void push(int x) {
            // x 是队列的队尾，是栈的栈顶
            q.offer(x);
            top_elem = x;
        }

        /**
         * 返回栈顶元素
         */
        public int top() {
            return top_elem;
        }

        /**
         * 删除栈顶的元素并返回
         */
        public int pop() {
            int size = q.size();
            // 留下队尾 2 个元素
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }
            // 记录新的队尾元素
            top_elem = q.peek();
            q.offer(q.poll());
            // 删除之前的队尾元素
            return q.poll();
        }

        /**
         * 判断栈是否为空
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
