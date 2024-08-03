package Algorithms._4_其他常见算法技巧.经典面试题.如何判定完美矩形;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/perfect-rectangle/
public class _391_完美矩形 {
    // 想判断最终形成的图形是否是完美矩形，需要从「面积」和「顶点」两个角度来处理
    // 1、判断面积，通过完美矩形的理论坐标计算出一个理论面积，然后和 rectangles 中小矩形的实际面积和做对比。
    // 2、判断顶点，points 集合中应该只剩下 4 个顶点且剩下的顶点必须都是完美矩形的理论顶点。

    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
            int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

            Set<String> points = new HashSet<>();
            int actualArea = 0;
            for (int[] rect : rectangles) {
                int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
                // 计算完美矩形的理论顶点坐标
                X1 = Math.min(X1, x1);
                Y1 = Math.min(Y1, y1);
                X2 = Math.max(X2, x2);
                Y2 = Math.max(Y2, y2);
                // 累加小矩形的面积
                actualArea += (x2 - x1) * (y2 - y1);
                // 记录最终形成的图形中的顶点
                String p1 = x1 + "," + y1;
                String p2 = x1 + "," + y2;
                String p3 = x2 + "," + y1;
                String p4 = x2 + "," + y2;
                for (String p : new String[] { p1, p2, p3, p4 }) {
                    if (points.contains(p)) {
                        points.remove(p);
                    } else {
                        points.add(p);
                    }
                }
            }
            // 判断面积是否相同
            int expectedArea = (X2 - X1) * (Y2 - Y1);
            if (actualArea != expectedArea) {
                return false;
            }
            // 判断最终留下的顶点个数是否为 4
            if (points.size() != 4) {
                return false;
            }
            // 判断留下的 4 个顶点是否是完美矩形的顶点
            if (!points.contains(X1 + "," + Y1))
                return false;
            if (!points.contains(X1 + "," + Y2))
                return false;
            if (!points.contains(X2 + "," + Y1))
                return false;
            if (!points.contains(X2 + "," + Y2))
                return false;
            // 面积和顶点都对应，说明矩形符合题意
            return true;
        }
    }
}
