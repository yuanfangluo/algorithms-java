import java.util.LinkedHashMap;

// https://leetcode.cn/problems/lru-cache/
public class _146_LRU缓存 {
    // 「为什么必须要用双向链表」
    // 因为我们需要删除操作。删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针，
    // 而双向链表才能支持直接查找前驱，保证操作的时间复杂度 O(1)。

    // 注意我们实现的双链表 API 只能从尾部插入，也就是说靠尾部的数据是最近使用的，靠头部的数据是最久未使用的。

    // 为什么要在链表中同时存储 key 和 val，而不是只存储 val
    // 注意 removeLeastRecently 函数中，我们需要用 deletedNode 得到 deletedKey。

    // 也就是说，当缓存容量已满，我们不仅仅要删除最后一个 Node 节点，还要把 map 中映射到该节点的 key 同时删除，而这个 key 只能由 Node 得到。
    // 如果 Node 结构中只存储 val，那么我们就无法得知 key 是什么，就无法删除 map 中的键，造成错误。

    // 使用哈希链表：哈希表和双向链表的结合
    class LRUCache {
        int cap;
        
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                // 获取链表头部的key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }
}
