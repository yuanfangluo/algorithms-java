package Algorithms._1_经典数据结构算法.手把手设计数据结构.更多经典设计习题;

// https://leetcode.cn/problems/flatten-2d-vector/
public class _251_展开二维向量 {
    class Vector2D {
        private int[][] vec;
        // 二维数组的遍历指针
        private int i = 0, j = 0;

        public Vector2D(int[][] vec) {
            this.vec = vec;
        }

        public int next() {
            if (!hasNext()) {
                // 按照题目的输入，应该不会进入这个 if 分支
                return -1;
            }
            int res = vec[i][j];
            j++;
            return res;
        }

        public boolean hasNext() {
            // 可能存在空数组行，用 while 循环跳过这种情况
            while (i < vec.length && j == vec[i].length) {
                // 跳到下一行的开头
                i++;
                j = 0;
            }

            if (i == vec.length) {
                // 已经遍历完所有行
                return false;
            }
            
            return true;
        }
    }
}
