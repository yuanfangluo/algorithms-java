package Algorithms.数据结构及排序.手把手带你实现哈希表.用拉链法实现哈希表;

import java.util.LinkedList;

// 用拉链法解决哈希冲突的简化实现
public class ExampleChainingHashMap {
    // 链表节点，存储 key-value 对儿
    // 注意这里必须存储同时存储 key 和 value
    // 因为要通过 key 找到对应的 value
    static class KVNode {
        int key;
        int value;

        // 为了简化，我这里直接用标准库的 LinkedList 链表
        // 所以这里就不添加 next 指针了
        // 你当然可以给 KVNode 添加 next 指针，自己实现链表操作
        public KVNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 底层 table 数组中的每个元素是一个链表
    private LinkedList<KVNode>[] table;

    public ExampleChainingHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    private int hash(int key) {
        return key % table.length;
    }

    // 查
    public int get(int key) {
        int index = hash(key);

        if (table[index] == null) {
            // 链表为空，说明 key 不存在
            return -1;
        }

        LinkedList<KVNode> list = table[index];
        // 遍历链表，尝试查找目标 key，返回对应的 value
        for (KVNode node : list) {
            if (node.key == key) {
                return node.value;
            }
        }

        // 链表中没有目标 key
        return -1;
    }

    // 增/改
    public void put(int key, int value) {
        int index = hash(key);

        if (table[index] == null) {
            // 链表为空，新建一个链表，插入 key-value
            table[index] = new LinkedList<>();
            table[index].add(new KVNode(key, value));
            return;
        }

        // 链表不为空，要遍历一遍看看 key 是否已经存在
        // 如果存在，更新 value
        // 如果不存在，插入新节点
        LinkedList<KVNode> list = table[index];
        for (KVNode node : list) {
            if (node.key == key) {
                // key 已经存在，更新 value
                node.value = value;
                return;
            }
        }

        // 链表中没有目标 key，添加新节点
        // 这里使用 addFirst 添加到链表头部或者 addLast 添加到链表尾部都可以
        // 因为 Java LinkedList 的底层实现是双链表，头尾操作都是 O(1) 的
        // https://labuladong.online/algo/data-structure-basic/linkedlist-implement/
        list.addLast(new KVNode(key, value));
    }

    // 删
    public void remove(int key) {
        LinkedList<KVNode> list = table[hash(key)];
        if (list == null) {
            return;
        }

        // 如果 key 存在，则删除
        // 这个 removeIf 方法是 Java LinkedList 的方法，可以删除满足条件的元素，时间复杂度 O(N)
        list.removeIf(node -> node.key == key);
    }
}
