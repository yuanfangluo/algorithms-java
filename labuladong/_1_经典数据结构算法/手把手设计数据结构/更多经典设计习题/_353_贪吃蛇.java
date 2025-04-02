package labuladong._1_经典数据结构算法.手把手设计数据结构.更多经典设计习题;

import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.cn/problems/design-snake-game/
public class _353_贪吃蛇 {
    class SnakeGame {
        // 记录蛇身位置的列表
        LinkedList<Integer> body = new LinkedList<>();
        // 记录蛇身位置的集合，便于快速判断是否咬到了自己
        HashSet<Integer> set = new HashSet<>();
        // 顺序记录食物出现的位置
        LinkedList<Integer> food = new LinkedList<>();
        // m 行 n 列的格子
        int m, n;
        // 记录蛇是否还活着
        boolean alive = true;

        public SnakeGame(int width, int height, int[][] food) {
            this.n = width;
            this.m = height;

            // 蛇头初始化在 (0, 0) 点
            set.add(encode(0, 0));
            body.add(encode(0, 0));

            for (int[] p : food) {
                this.food.addLast(encode(p[0], p[1]));
            }
        }

        // 将二维坐标编码成数字
        int encode(int x, int y) {
            return x * n + y;
        }

        // 贪吃蛇移动
        public int move(String direction) {
            if (!alive) {
                return -1;
            }

            int head = body.getFirst();

            // 解码蛇头位置的二维坐标
            int x = head / n, y = head % n;
            // 计算移动后的位置坐标
            int nx = x, ny = y;
            switch (direction) {
                case "U":
                    nx--;
                    break;
                case "L":
                    ny--;
                    break;
                case "R":
                    ny++;
                    break;
                case "D":
                    nx++;
                    break;
            }

            // 新的位置
            int code = encode(nx, ny);

            // 出界判断
            if (nx < 0 || nx == m || ny == n || ny < 0) {
                alive = false;
                return -1;
            }

            // 前进一位
            body.addFirst(code);
            if (!food.isEmpty() && food.getFirst() == code) {
                // 吃到食物，不删尾巴
                food.removeFirst();
            } else {
                // 如果没有食物，删掉尾巴
                set.remove(body.removeLast());
            }

            if (set.contains(code)) {
                // 咬到了自己
                alive = false;
                return -1;
            }
            
            set.add(code);

            // 分数是吃到食物的个数，即身体长度减一
            return body.size() - 1;
        }
    }
}
