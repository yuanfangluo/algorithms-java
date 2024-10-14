package Algorithms._1_经典数据结构算法.手把手刷图算法.名流问题;

import java.util.LinkedList;

// https://leetcode.cn/problems/find-the-celebrity/
public class _277_搜寻名人 {
    // 这个节点没有一条指向其他节点的有向边；且其他所有节点都有一条指向这个节点的有向边。
    // 名人节点的出度为 0，入度为 n - 1

    // 暴力解法
    class Solution1 {
        int findCelebrity(int n) {
            for (int cand = 0; cand < n; cand++) {
                int other;
                for (other = 0; other < n; other++) {
                    // 排除自己
                    if (cand == other)
                        continue;
                    // 保证其他人都认识 cand，且 cand 不认识任何其他人
                    // 否则 cand 就不可能是名人
                    if (knows(cand, other) || !knows(other, cand)) {
                        break;
                    }
                }
                // 代表已经遍历完了所有人
                if (other == n) {
                    // 找到名人
                    return cand;
                }
            }
            // 没有一个人符合名人特性
            return -1;
        }
    }
    // knows 函数底层就是在访问一个二维的邻接矩阵，一次调用的时间复杂度是 O(1)，所以这个暴力解法整体的最坏时间复杂度是 O(N^2)。

    // 那么，是否有其他高明的办法来优化时间复杂度呢？其实是有优化空间的，你想想，我们现在最耗时的地方在哪里？

    // 对于每一个候选人 cand，我们都要用一个内层 for 循环去判断这个 cand 到底符不符合「名人」的条件。
    // 这个内层 for 循环看起来就蠢，虽然判断一个人「是名人」必须用一个 for 循环，但判断一个人「不是名人」就不用这么麻烦了。
    // 因为「名人」的定义保证了「名人」的唯一性，所以我们可以利用排除法，先排除那些显然不是「名人」的人，从而避免 for 循环的嵌套，降低时间复杂度。
    // 它保证了人群中最多有一个名人。这很好理解，如果有两个人同时是名人，那么这两条定义就自相矛盾了。
    // 只要观察任意两个候选人的关系，我一定能确定其中的一个人不是名人，把他排除。

    // 至于另一个候选人是不是名人，只看两个人的关系肯定是不能确定的，但这不重要，重要的是排除掉一个必然不是名人的候选人，缩小了包围圈。
    // 这是优化的核心，也是比较难理解的，所以我们先来说说为什么观察任意两个候选人的关系，就能排除掉一个。
    // 你想想，两个人之间的关系可能是什么样的？

    /*
     * if (knows(cand, other) || !knows(other, cand)) {
     * cand 不可能是名人
     * } else { !knows(cand, other) || knows(other, cand)
     * other 不可能是名人
     * }
     */

    class Solution2 {
        int findCelebrity(int n) {
            if (n == 1)
                return 0;
            // 将所有候选人装进队列
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.addLast(i);
            }
            // 一直排除，直到只剩下一个候选人停止循环
            while (q.size() >= 2) {
                // 每次取出两个候选人，排除一个
                int cand = q.removeFirst();
                int other = q.removeFirst();
                if (knows(cand, other) || !knows(other, cand)) {
                    // cand 不可能是名人，排除，让 other 归队
                    q.addFirst(other);
                } else { // !knows(cand, other) || knows(other, cand)
                    // other 不可能是名人，排除，让 cand 归队
                    q.addFirst(cand);
                }
            }

            // 现在排除得只剩一个候选人，判断他是否真的是名人
            int cand = q.removeFirst();
            for (int other = 0; other < n; other++) {
                if (other == cand) {
                    continue;
                }
                // 保证其他人都认识 cand，且 cand 不认识任何其他人
                if (!knows(other, cand) || knows(cand, other)) {
                    return -1;
                }
            }
            // cand 是名人
            return cand;
        }
    }
    // 这个算法避免了嵌套 for 循环，时间复杂度降为 O(N) 了，
    // 不过引入了一个队列来存储候选人集合，使用了 O(N) 的空间复杂度。

    // 最终解法
    // 解决名人问题的解法时间复杂度为 O(N)，空间复杂度为 O(1)，已经是最优解法
    class Solution3 {
        int findCelebrity(int n) {
            // 先假设 cand 是名人
            int cand = 0;
            for (int other = 1; other < n; other++) {
                if (!knows(other, cand) || knows(cand, other)) {
                    // cand 不可能是名人，排除
                    // 假设 other 是名人
                    cand = other;
                } else {
                    // other 不可能是名人，排除
                    // 什么都不用做，继续假设 cand 是名人
                }
            }

            // 现在的 cand 是排除的最后结果，但不能保证一定是名人
            for (int other = 0; other < n; other++) {
                if (cand == other)
                    continue;
                // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
                if (!knows(other, cand) || knows(cand, other)) {
                    return -1;
                }
            }
            return cand;
        }
    }

    // 可以直接调用，能够返回 i 是否认识 j
    boolean knows(int i, int j) {
        return true;
    }

}
