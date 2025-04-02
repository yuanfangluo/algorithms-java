package labuladong._1_经典数据结构算法.手把手设计数据结构.单调栈的变体.习题;

import java.util.ArrayList;
import java.util.Stack;

import labuladong.Base.ListNode;

// https://leetcode.cn/problems/next-greater-node-in-linked-list/
public class _1019_链表中的下一个更大节点 {
    // 这道题输入的是一条单链表，我们把它转化成数组，
    // 方便用索引访问即可直接套用 单调栈模板 中的 nextGreaterElement 函数逻辑。
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            // 把单链表转化成数组，方便通过索引访问
            ArrayList<Integer> nums = new ArrayList<>();
            for (ListNode p = head; p != null; p = p.next) {
                nums.add(p.val);
            }
            // 存放答案的数组
            int[] res = new int[nums.size()];
            Stack<Integer> stk = new Stack<>();
            // 单调栈模板，求下一个更大元素，从后往前遍历
            for (int i = nums.size() - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() <= nums.get(i)) {
                    stk.pop();
                }
                // 本题要求没有下一个更大元素时返回 0
                res[i] = stk.isEmpty() ? 0 : stk.peek();
                stk.push(nums.get(i));
            }
            return res;
        }
    }
}
