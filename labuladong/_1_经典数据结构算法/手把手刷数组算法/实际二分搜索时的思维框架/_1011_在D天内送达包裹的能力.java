package labuladong._1_经典数据结构算法.手把手刷数组算法.实际二分搜索时的思维框架;

// https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
public class _1011_在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int days) {
        // 船的最小载重是多少？最大载重是多少？
        // 显然，船的最小载重应该是 weights 数组中元素的最大值，因为每次至少得装一件货物走，不能说装不下嘛。
        // 最大载重显然就是weights 数组所有元素之和，也就是一次把所有货物都装走。
        // 搜索区间 [left, right)
        int left = 0;
        // 注意，right 是开区间，所以额外加一
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            } else if (f(weights, mid) < days) {
                // 需要让 f(x) 的返回值大一些
                right = mid;
            } else if (f(weights, mid) > days) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减

    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }

}
