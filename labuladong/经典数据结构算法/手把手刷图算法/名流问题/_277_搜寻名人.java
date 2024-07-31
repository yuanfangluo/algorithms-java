package labuladong.经典数据结构算法.手把手刷图算法.名流问题;

import java.util.LinkedList;

// https://leetcode.cn/problems/find-the-celebrity/
public class _277_搜寻名人 {
    // 这个节点没有一条指向其他节点的有向边；且其他所有节点都有一条指向这个节点的有向边。
    // 名人节点的出度为 0，入度为 n - 1
    // 图有两种存储形式，一种是邻接表，一种是邻接矩阵，
    // 邻接表的主要优势是节约存储空间；邻接矩阵的主要优势是可以迅速判断两个节点是否相邻。
    // 对于名人问题，显然会经常需要判断两个人之间是否认识，也就是两个节点是否相邻，
    // 所以我们可以用邻接矩阵来表示人和人之间的社交关系。

    // 暴力解法
    class Solution1 {
        int findCelebrity(int n) {
            for (int cand = 0; cand < n; cand++) {
                int other;
                for (other = 0; other < n; other++) {
                    if (cand == other)
                        continue;
                    // 保证其他人都认识 cand，且 cand 不认识任何其他人
                    // 否则 cand 就不可能是名人
                    if (knows(cand, other) || !knows(other, cand)) {
                        break;
                    }
                }
                if (other == n) {
                    // 找到名人
                    return cand;
                }
            }
            // 没有一个人符合名人特性
            return -1;
        }
    }

    // 排除法
    // 因为「名人」的定义保证了「名人」的唯一性，所以我们可以利用排除法，
    // 先排除那些显然不是「名人」的人，从而避免 for 循环的嵌套，降低时间复杂度。
    // 名人的定义就很有意思，它保证了人群中最多有一个名人。
    // 先想想两个人之间的关系可能是什么样的？
    // 无非就是四种：
    // 你认识我我不认识你，
    // 我认识你你不认识我，
    // 咱俩互相认识，
    // 咱两互相不认识。

    /*
     * if (knows(cand, other) || !knows(other, cand)) {
     * cand 不可能是名人
     * } else {
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
                } else {
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
                if (cand == other) continue;
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
