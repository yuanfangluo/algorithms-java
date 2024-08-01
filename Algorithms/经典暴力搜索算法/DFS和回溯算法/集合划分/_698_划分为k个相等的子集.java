package Algorithms.经典暴力搜索算法.DFS和回溯算法.集合划分;

import java.util.HashMap;

// https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
public class _698_划分为k个相等的子集 {
    // 把装有 n 个数字的数组 nums 分成 k 个和相同的集合，
    // 你可以想象将 n 个数字分配到 k 个「桶」里，最后这 k 个「桶」里的数字之和要相同。

    // 将 n 个数字分配到 k 个桶里，我们也可以有两种视角：
    // 视角一，如果我们切换到这 n 个数字的视角，每个数字都要选择进入到 k 个桶中的某一个。

    class Solution {
        boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length)
                return false;
            int sum = 0;
            for (int v : nums)
                sum += v;
            if (sum % k != 0)
                return false;

            // k 个桶（集合），记录每个桶装的数字之和
            int[] bucket = new int[k];
            // 理论上每个桶（集合）中数字的和
            int target = sum / k;
            // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
            return backtrack(nums, 0, bucket, target);
        }

        // 递归穷举 nums 中的每个数字
        boolean backtrack(int[] nums, int index, int[] bucket, int target) {
            if (index == nums.length) {
                // 检查所有桶的数字之和是否都是 target
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] != target) {
                        return false;
                    }
                }
                // nums 成功平分成 k 个子集
                return true;
            }

            // 穷举 nums[index] 可能装入的桶
            for (int i = 0; i < bucket.length; i++) {
                // 剪枝，桶装装满了
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                // 将 nums[index] 装入 bucket[i]
                bucket[i] += nums[index];

                // 递归穷举下一个数字的选择
                if (backtrack(nums, index + 1, bucket, target)) {
                    return true;
                }
                // 撤销选择
                bucket[i] -= nums[index];
            }

            // nums[index] 装入哪个桶都不行
            return false;
        }
    }

    // 视角二，如果我们切换到这 k 个桶的视角，对于每个桶，都要遍历 nums 中的 n 个数字，然后选择是否将当前遍历到的数字装进自己这个桶里。
    // 以桶的视角进行穷举，每个桶需要遍历 nums 中的所有数字，决定是否把当前数字装进桶中；
    // 当装满一个桶之后，还要装下一个桶，直到所有桶都装满为止。
    class Solution2 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length)
                return false;
            int sum = 0;
            for (int v : nums)
                sum += v;
            if (sum % k != 0)
                return false;

            int used = 0; // 使用位图技巧
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack(k, 0, nums, 0, used, target);
        }

        HashMap<Integer, Boolean> memo = new HashMap<>();

        boolean backtrack(int k, int bucket,
                int[] nums, int start, int used, int target) {
            // base case
            if (k == 0) {
                // 所有桶都被装满了，而且 nums 一定全部用完了
                return true;
            }
            if (bucket == target) {
                // 装满了当前桶，递归穷举下一个桶的选择
                // 让下一个桶从 nums[0] 开始选数字
                boolean res = backtrack(k - 1, 0, nums, 0, used, target);
                // 缓存结果
                memo.put(used, res);
                return res;
            }

            if (memo.containsKey(used)) {
                // 避免冗余计算
                return memo.get(used);
            }

            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                    // nums[i] 已经被装入别的桶中
                    continue;
                }
                if (nums[i] + bucket > target) {
                    continue;
                }
                // 做选择
                used |= 1 << i; // 将第 i 位置为 1
                bucket += nums[i];
                // 递归穷举下一个数字是否装入当前桶
                if (backtrack(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                used ^= 1 << i; // 使用异或运算将第 i 位恢复 0
                bucket -= nums[i];
            }

            return false;
        }
    }

    // 总结
    // 本文写的这两种思路都可以算出正确答案，不过第一种解法即便经过了排序优化，也明显比第二种解法慢很多，这是为什么呢？
    // 我们来分析一下这两个算法的时间复杂度，假设 nums 中的元素个数为 n。
    // 先说第一个解法，也就是从数字的角度进行穷举，n 个数字，每个数字有 k 个桶可供选择，
    // 所以组合出的结果个数为 k^n，时间复杂度也就是 O(k^n)。

    // 第二个解法，每个桶要遍历 n 个数字，对每个数字有「装入」或「不装入」两种选择，所以组合的结果有 2^n 种；
    // 而我们有 k 个桶，所以总的时间复杂度为 O(k*2^n)。
    // 当然，这是对最坏复杂度上界的粗略估算，实际的复杂度肯定要好很多，毕竟我们添加了这么多剪枝逻辑。
    // 不过，从复杂度的上界已经可以看出第一种思路要慢很多了。
    // 所以，谁说回溯算法没有技巧性的？
    // 虽然回溯算法就是暴力穷举，但穷举也分聪明的穷举方式和低效的穷举方式，关键看你以谁的「视角」进行穷举。

    // 通俗来说，我们应该尽量「少量多次」，就是说宁可多做几次选择（乘法关系），也不要给太大的选择空间（指数关系）；
    // 做 n 次「k 选一」仅重复一次（O(k^n)），比 n 次「二选一」重复 k 次（O(k*2^n)）效率低很多。
}
