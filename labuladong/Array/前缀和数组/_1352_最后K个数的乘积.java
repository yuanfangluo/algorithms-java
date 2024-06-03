package labuladong.Array.前缀和数组;

import java.util.ArrayList;

public class _1352_最后K个数的乘积 {
    class ProductOfNumbers {

        // 前缀积数组
        // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
        ArrayList<Integer> preProduct = new ArrayList<>();

        public ProductOfNumbers() {
            // 初始化放一个 1，便于计算后续添加元素的乘积
            preProduct.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                // 如果添加的元素是 0，则前面的元素积都废了
                preProduct.clear();
                preProduct.add(1);
                return;
            }
            int n = preProduct.size();
            // 前缀积数组中每个元素
            preProduct.add(preProduct.get(n - 1) * num);
        }

        public int getProduct(int k) {
            int n = preProduct.size();
            if (k > n - 1) {
                // 不足 k 个元素，是因为最后 k 个元素存在 0
                return 0;
            }
            // 计算最后 k 个元素积
            return preProduct.get(n - 1) / preProduct.get(n - k - 1);
        }
    }
}
