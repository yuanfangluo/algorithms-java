package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/most-frequent-subtree-sum/
public class _508_出现次数最多的子树元素和 {
    // 这道题需要用到「分解问题」的思维，同时要利用后序位置来计算答案。
    // 定义一个函数：输入一个节点，返回以该节点为根的二叉树所有节点之和。
    class Solution2 {
        // sum -> count
        HashMap<Integer, Integer> sumToCount = new HashMap<>();

        // 定义：输入一个节点，返回以该节点为根的二叉树所有节点之和
        int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int res = root.val + leftSum + rightSum;

            // 后序遍历位置，顺手记录子树和对应的频率
            sumToCount.put(res, sumToCount.getOrDefault(res, 0) + 1);
            return res;
        }


        public int[] findFrequentTreeSum(TreeNode root) {
            // 遍历二叉树，记录所有子树和及出现频率
            sum(root);

            // 找到最大的出现频率
            int maxCount = 0;
            for (int count : sumToCount.values()) {
                maxCount = Math.max(maxCount, count);
            }

            // 找到最大出现频率对应的的子树和
            ArrayList<Integer> res = new ArrayList<>();
            for (Integer key : sumToCount.keySet()) {
                if (sumToCount.get(key) == maxCount) {
                    res.add(key);
                }
            }
            
            // 转化为 Java 数组
            int[] arr = new int[res.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }

    class Solution {
        int maxCount = 0;
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    res.add(entry.getKey());
                }
            }
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = root.val + left + right;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(maxCount, map.get(sum));
            return sum;
        }
    }
}
