package Algorithms.数据结构基础.手把手带你实现哈希表.用线性探测法实现哈希表;

// 用线性探查法解决哈希冲突的简化实现（特殊占位符版）
public class ExampleLinearProbingHashMap2 {

    private static class KVNode {
        int key;
        int val;

        public KVNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 用于标记被删元素的占位符
    // 里面的值可以随意存储，因为只会使用 == 判断指针相等，不用比较里面的值
    private final KVNode DELETED = new KVNode(-2, -2);

    // 真正存储键值对的数组
    private final KVNode[] table;

    public ExampleLinearProbingHashMap2(int initCapacity) {
        table = new KVNode[initCapacity];
    }

    // 增/改
    public void put(int key, int val) {
        int index = findKeyIndex(key);
        if (index != -1) {
            // key 已存在，修改对应的 val
            KVNode node = table[index];
            if (node != null) {
                node.val = val;
                return;
            }
        }

        // key 不存在
        KVNode node = new KVNode(key, val);
        // 在 table 中找一个空位或者占位符进行插入
        index = hash(key);
        while (table[index] != null && table[index] != DELETED) {
            index = (index + 1) % table.length;
        }
        table[index] = node;
    }

    // 删
    public void remove(int key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            // key 不存在，不需要 remove
            return;
        }
        // 直接用占位符表示删除
        table[index] = DELETED;
    }

    // 查，返回 key 对应的 val，如果 key 不存在，则返回 -1
    public int get(int key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            return -1;
        }

        return table[index].val;
    }

    // 线性探测法查找 key 在 table 中的索引
    // 如果找不到，返回 -1
    private int findKeyIndex(int key) {
        // 因为删除元素时只是标记为 DELETED，并不是真的删除
        // 所以 table 可能会被填满，导致死循环
        // step 用来记录查找的步数，防止死循环
        int step = 0;
        // 注意环形数组特性
        for (int i = hash(key); table[i] != null; i = (i + 1) % table.length) {
            if (table[i] == DELETED) {
                // 遇到占位符直接跳过
                continue;
            }
            if (table[i].key == key) {
                return i;
            }
            step++;
            // 防止死循环
            if (step == table.length) {
                return -1;
            }
        }

        return -1;
    }

    // 哈希函数，将键映射到 table 的索引
    private int hash(int key) {
        return key % table.length;
    }

    public static void main(String[] args) {
        ExampleLinearProbingHashMap2 map = new ExampleLinearProbingHashMap2(10);
        map.put(1, 1);
        map.put(2, 2);
        map.put(10, 10);
        map.put(20, 20);
        map.put(30, 30);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2
        System.out.println(map.get(20)); // 20

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(20);
        System.out.println(map.get(20)); // -1
        System.out.println(map.get(30)); // 30
    }
}
