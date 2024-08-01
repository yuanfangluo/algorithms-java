package Algorithms.other;

public class Product_乘积 {

    int[] prefix(int[] nums) {
        int n = nums.length;
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        return prefix;
    }

    int[] suffix(int[] nums) {
        int n = nums.length;
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        return suffix;
    }

}
