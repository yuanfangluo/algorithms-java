package labuladong.数据结构及排序.手把手带你实现哈希集合;

import java.util.HashMap;

public class MyHashSet<K> {
    // 随便创建一个值，作为 value 占位符
    private static final Object PRESENT = new Object();
    // 底层 HashMap，我这里直接用标准库了，你用前文自己实现的哈希表也可以
    private final HashMap<K, Object> map = new HashMap<>();

    public void add(K key) {
        // 向哈希表添加一个键值对
        map.put(key, PRESENT);
    }

    public void remove(K key) {
        // 从哈希表中移除键 key
        map.remove(key);
    }

    public boolean contains(K key) {
        // 判断哈希表中是否包含键 key
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }
}
