package labuladong.其他常见算法技巧.数学运用技巧.谈谈游戏中的随机算法;

import java.util.Random;

import labuladong.Base.ListNode;

public class _382_链表随机节点 {
    /* 返回链表中一个随机节点的值 */
    class Solution1 {
        int getRandom(ListNode head) {
            Random r = new Random();
            int i = 0, res = 0;
            ListNode p = head;
            // while 循环遍历链表
            while (p != null) {
                i++;
                // 生成一个 [0, i) 之间的整数
                // 这个整数等于 0 的概率就是 1/i
                if (0 == r.nextInt(i)) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

    class Solution2 {
        /* 返回链表中 k 个随机节点的值 */
        int[] getRandom(ListNode head, int k) {
            Random r = new Random();
            int[] res = new int[k];
            ListNode p = head;

            // 前 k 个元素先默认选上
            for (int i = 0; i < k && p != null; i++) {
                res[i] = p.val;
                p = p.next;
            }

            int i = k;
            // while 循环遍历链表
            while (p != null) {
                i++;
                // 生成一个 [0, i) 之间的整数
                int j = r.nextInt(i);
                // 这个整数小于 k 的概率就是 k/i
                if (j < k) {
                    res[j] = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
}
