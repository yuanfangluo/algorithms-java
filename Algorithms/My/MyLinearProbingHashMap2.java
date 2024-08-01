package Algorithms.My;

import java.util.LinkedList;
import java.util.List;

public class MyLinearProbingHashMap2<K, V> {
     private static class KVNode<K, V> {
        K key;
        V val;

        KVNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // 被删除的 KVNode 的占位符
    private final KVNode<K, V> DUMMY = new KVNode<>(null, null);

    // 真正存储键值对的 table 数组
    private KVNode<K, V>[] table;
    // HashMap 中的键值对个数
    private int size;
    // 默认的初始化容量
    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap2() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap2(int cap) {
        size = 0;
        table = (KVNode<K, V>[]) new KVNode[cap];
    }

    /***** 增/改 *****/

    // 添加 key -> val 键值对
    // 如果键 key 已存在，则将值修改为 val
    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        // 负载因子默认设为 0.75，超过则扩容
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }

        int index = getKeyIndex(key);
        if (index != -1) {
            // key 已存在，修改对应的 val
            table[index].val = val;
            return;
        }

        // key 不存在
        KVNode<K, V> x = new KVNode<>(key, val);
        // 在 table 中找一个空位或者占位符，插入
        index = hash(key);
        while (table[index] != null && table[index] != DUMMY) {
            index = (index + 1) % table.length;
        }
        table[index] = x;
        size++;
    }

    /***** 删 *****/

    // 删除 key 和对应的 val，并返回 val
    // 若 key 不存在，则返回 null
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        // 缩容
        if (size < table.length / 8) {
            resize(table.length / 2);
        }

        int index = getKeyIndex(key);
        if (index == -1) {
            // key 不存在，不需要 remove
            return;
        }

        // 开始 remove
        // 直接用占位符表示删除
        table[index] = DUMMY;
        size--;
    }

    /***** 查 *****/

    // 返回 key 对应的 val
    // 如果 key 不存在，则返回 null
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int index = getKeyIndex(key);
        if (index == -1) {
            return null;
        }

        return table[index].val;
    }

    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                keys.addLast(entry.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }

    // 对 key 进行线性探查，返回一个索引
    // 根据 keys[i] 是否为 null 判断是否找到对应的 key
    private int getKeyIndex(K key) {
        int step = 0;
        for (int i = hash(key); table[i] != null; i = (i + 1) % table.length) {
            KVNode<K, V> entry = table[i];
            // 遇到占位符直接跳过
            if (entry == DUMMY) {
                continue;
            }
            if (entry.key.equals(key)) {
                return i;
            }
            step++;
            // 防止死循环
            if (step == table.length) {
                // 这里可以触发一次 resize，把标记为删除的占位符清理掉
                resize(table.length);
                return -1;
            }
        }
        return -1;
    }

    // 哈希函数，将键映射到 table 的索引
    // [0, table.length - 1]
    private int hash(K key) {
        // int: 0000 0000 0000 ... 0000
        //    : 0111 1111 1111 ... 1111
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int cap) {
        MyLinearProbingHashMap2<K, V> newMap = new MyLinearProbingHashMap2<>(cap);
        for (KVNode<K, V> entry : table) {
            if (entry != null && entry != DUMMY) {
                newMap.put(entry.key, entry.val);
            }
        }
        this.table = newMap.table;
    }

    public static void main(String[] args) {
        MyLinearProbingHashMap2<Integer, Integer> map = new MyLinearProbingHashMap2<>();
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
        System.out.println(map.get(20)); // null
        System.out.println(map.get(30)); // 30
    }
}
