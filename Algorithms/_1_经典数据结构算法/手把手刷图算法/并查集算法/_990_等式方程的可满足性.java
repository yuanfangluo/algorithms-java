package Algorithms._1_经典数据结构算法.手把手刷图算法.并查集算法;

import Algorithms.Base.UF;

// https://leetcode.cn/problems/satisfiability-of-equality-equations/
public class _990_等式方程的可满足性 {
    // 将 equations 中的算式根据 == 和 != 分成两部分，先处理 == 算式，使得他们通过相等关系各自勾结成门派（连通分量）；
    // 然后处理 != 算式，检查不等关系是否破坏了相等关系的连通性。
    class Solution {
        boolean equationsPossible(String[] equations) {
            // 26 个英文字母
            UF uf = new UF(26);

            // 先让相等的字母形成连通分量
            for (String eq : equations) {
                if (eq.charAt(1) == '=') {
                    char x = eq.charAt(0);
                    char y = eq.charAt(3);
                    uf.union(x - 'a', y - 'a');
                }
            }

            // 检查不等关系是否打破相等关系的连通性
            for (String eq : equations) {
                if (eq.charAt(1) == '!') {
                    char x = eq.charAt(0);
                    char y = eq.charAt(3);
                    // 如果相等关系成立，就是逻辑冲突
                    if (uf.connected(x - 'a', y - 'a'))
                        return false;
                }
            }
            return true;
        }

    }
}
