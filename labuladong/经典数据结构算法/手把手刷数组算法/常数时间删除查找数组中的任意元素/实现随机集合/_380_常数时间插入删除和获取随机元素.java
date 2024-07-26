package labuladong.经典数据结构算法.手把手刷数组算法.常数时间删除查找数组中的任意元素.实现随机集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/insert-delete-getrandom-o1/
public class _380_常数时间插入删除和获取随机元素 {
    // 
    class RandomizedSet {
    // 存储元素的值
    List<Integer> nums;
    // 记录每个元素对应在 nums 中的索引
    Map<Integer, Integer> valToIndex;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        // 若 val 已存在，不用再插入
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 若 val 不存在，插入到 nums 尾部，
        // 并记录 val 对应的索引值
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        // 若 val 不存在，不用再删除
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // 先拿到 val 的索引
        int index = valToIndex.get(val);
        // 将最后一个元素对应的索引修改为 index
        valToIndex.put(nums.get(nums.size() - 1), index);
        // 交换 val 和最后一个元素
        Collections.swap(nums, index, nums.size() - 1);
        // 在数组中删除元素 val
        nums.remove(nums.size() - 1);
        // 删除元素 val 对应的索引
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        // 随机获取 nums 中的一个元素
        return nums.get((int) (Math.random() * nums.size()));
    }
}
}
