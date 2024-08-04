package bytedance;
// https://leetcode.cn/problems/coordinate-with-maximum-network-quality/
public class _1620_网络信号最好的坐标 {
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            // 遍历所有坐标，坐标的范围为(xMin, xMax)，(yMin, yMax)
            int xMax = 50, yMax = 50;
            int xMin = 0, yMin = 0;
            for (int[] tower : towers) {
                int x = tower[0], y = tower[1];
                xMax = Math.max(xMax, x);
                xMin = Math.min(xMin, x);
                yMax = Math.max(yMax, y);
                yMin = Math.min(yMin, y);
            }
            // 由于x, y ,q的取值范围都是从0开始，如果q为0，坐标还必须是字典序最小，那么只能为(0, 0)
            // 因此默认值是(0, 0)，但是遍历范围可以为(xMin, xMax)，(yMin, yMax)
            int cx = 0, cy = 0;
            int maxQuality = 0;
            for (int x = xMin; x <= xMax; x++) {
                for (int y = yMin; y <= yMax; y++) {
                    int[] coordinate = { x, y };
                    int quality = 0;
                    for (int[] tower : towers) {
                        // 计算坐标与塔的距离
                        int squaredDistance = getSquaredDistance(coordinate, tower);
                        if (squaredDistance <= radius * radius) {
                            double distance = Math.sqrt(squaredDistance);
                            quality += (int) Math.floor(tower[2] / (1 + distance));
                        }
                    }
                    if (quality > maxQuality) {
                        cx = x;
                        cy = y;
                        maxQuality = quality;
                    }
                }
            }
            return new int[] { cx, cy };
        }

        public int getSquaredDistance(int[] coordinate, int[] tower) {
            return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0])
                    + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
        }
    }
}
