package labuladong._1_经典数据结构算法.手把手刷数组算法.差分数组;

// 差分数组工具类
public class Difference {
    // 差分数组
    // diff[i] 就是 nums[i] 和 nums[i-1] 之差
    private int[] diff;

    /* 输入一个初始数组，区间操作将在这个数组上进行 */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i, j] 增加 val（可以是负数） */
    // diff[i] += 3 意味着给 nums[i..] 所有的元素都加了 3，
    // 然后 diff[j+1] -= 3 又意味着对于 nums[j+1..] 所有元素再减 3，
    // 那综合起来，是不是就是对 nums[i..j] 中的所有元素都加 3 了
    public void increment(int i, int j, int val) {
        diff[i] += val;
        // 当 j+1 >= diff.length 时，说明是对 nums[i] 及以后的整个数组都进行修改，那么就不需要再给 diff 数组减 val 了
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    /* 返回结果数组 */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
