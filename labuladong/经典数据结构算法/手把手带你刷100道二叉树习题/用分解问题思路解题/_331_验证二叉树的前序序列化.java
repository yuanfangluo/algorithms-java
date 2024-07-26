package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.LinkedList;

// https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/
public class _331_验证二叉树的前序序列化 {
    
    public boolean isValidSerialization(String preorder) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : preorder.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }

    // 改造后的前序遍历反序列化函数
    // 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
    boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }

        // ***** 前序遍历位置 *****
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) return true;
        // *********************

        return deserialize(nodes) && deserialize(nodes);
    }
}
