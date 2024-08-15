package Algorithms.数据结构基础.手把手带你实现哈希表.用线性探测法实现哈希表;

// 用线性探查法解决哈希冲突的简化实现（rehash 版）
public class ExampleLinearProbingHashMap1 {

    private static class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 哈希表的底层数组，每个索引存储一个键值对
    private final Node[] table;

    public ExampleLinearProbingHashMap1(int cap) {
        table = new Node[cap];
    }

    // 增/改
    public void put(int key, int value) {
        int index = findKeyIndex(key);
        table[index] = new Node(key, value);
    }

    // 查，找不到就返回 -1
    public int get(int key) {
        int index = findKeyIndex(key);
        return table[index] == null ? -1 : table[index].val;
    }

    // 删
    public void remove(int key) {
        int index = findKeyIndex(key);
        if (table[index] == null) {
            return;
        }
        table[index] = null;
        // 保持元素连续性，搬移数据（这个过程称为 rehash）
        index = (index + 1) % table.length;
        while (table[index] != null) {
            Node entry = table[index];
            table[index] = null;
            // 这个操作是关键，利用 put 方法，将键值对重新插入
            // 这样就能把它们移动到正确的 table 索引位置
            put(entry.key, entry.val);
            index = (index + 1) % table.length;
        }
    }

    // 线性探测法查找 key 在 table 中的索引
    // 如果找不到，返回的就是下一个为 null 的索引，可用于插入
    private int findKeyIndex(int key) {
        int index = hash(key);

        while (table[index] != null) {
            if (table[index].key == key) {
                return index;
            }
            // 注意环形数组特性
            index = (index + 1) % table.length;
        }

        return index;
    }

    private int hash(int key) {
        return key % table.length;
    }

    public static void main(String[] args) {
        ExampleLinearProbingHashMap1 map = new ExampleLinearProbingHashMap1(10);
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
