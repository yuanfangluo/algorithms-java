package labuladong.My;

import java.util.LinkedList;
import java.util.List;

// rehash 方式实现的线性探查哈希表
public class MyLinearProbingHashMap1<K, V> {
     private static class KVNode<K, V> {
        K key;
        V val;

        KVNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // 真正存储键值对的数组
    private KVNode<K, V>[] table;
    // HashMap 中的键值对个数
    private int size;
    // 默认的初始化容量
    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap1() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap1(int initCapacity) {
        size = 0;
        table = (KVNode<K, V>[]) new KVNode[initCapacity];
    }

    /***** 增/改 *****/

    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        // 我们把负载因子默认设为 0.75，超过则扩容
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }

        int index = getKeyIndex(key);
        // key 已存在，修改对应的 val
        if (table[index] != null) {
            table[index].val = val;
            return;
        }

        // key 不存在，在空位插入
        table[index] = new KVNode<>(key, val);
        size++;
    }

    /***** 删 *****/

    // 删除 key 和对应的 val
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        // 缩容，当负载因子小于 0.125 时，缩容
        if (size <= table.length / 8) {
            resize(table.length / 4);
        }

        int index = getKeyIndex(key);

        if (table[index] == null) {
            // key 不存在，不需要 remove
            return;
        }

        // 开始 remove
        table[index] = null;
        size--;
        // 保持元素连续性，进行 rehash
        index = (index + 1) % table.length;
        for (; table[index] != null; index = (index + 1) % table.length) {
            KVNode<K, V> entry = table[index];
            table[index] = null;
            // 这里减一，因为 put 里面又会加一
            size--;
            put(entry.key, entry.val);

        }
    }

    /***** 查 *****/

    // 返回 key 对应的 val，如果 key 不存在，则返回 null
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        int index = getKeyIndex(key);
        if (table[index] == null) {
            return null;
        }
        return table[index].val;
    }

    // 返回所有 key（顺序不固定）
    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                keys.addLast(entry.key);
            }
        }
        return keys;
    }

    /***** 其他工具函数 *****/

    public int size() {
        return size;
    }

    // 哈希函数，将键映射到 table 的索引
    // [0, table.length - 1]
    private int hash(K key) {
        // int: 0000 0000 0000 ... 0000
        //    : 0111 1111 1111 ... 1111
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    // 对 key 进行线性探查，返回一个索引
    // 如果 key 不存在，返回的就是下一个为 null 的索引，可用于插入
    private int getKeyIndex(K key) {
        int index;
        for (index = hash(key); table[index] != null; index = (index + 1) % table.length) {
            if (table[index].key.equals(key))
                return index;
        }
        return index;
    }

    private void resize(int newCap) {
        MyLinearProbingHashMap1<K, V> newMap = new MyLinearProbingHashMap1<>(newCap);
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                newMap.put(entry.key, entry.val);
            }
        }
        this.table = newMap.table;
    }

    public static void main(String[] args) {
        MyLinearProbingHashMap1<Integer, Integer> map = new MyLinearProbingHashMap1<>();
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
