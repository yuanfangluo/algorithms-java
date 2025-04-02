package labuladong.other;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 
public class _1146_快照数组 {
    class SnapshotArray {
        private int snapId;
    
        // index -> (snapid -> val)
        private final Map<Integer, TreeMap<Integer, Integer>> array;
    
        public SnapshotArray(int length) {
            snapId = 0;
            array = new HashMap<>(length);
        }
        
        public void set(int index, int val) {
            array.computeIfAbsent(index, k-> new TreeMap<>()).put(snapId, val);
        }
        
        public int snap() {
            return snapId++;
        }
        
        public int get(int index, int snap_id) {
            Map.Entry<Integer, Integer> entry = array.computeIfAbsent(index, k -> new TreeMap<>()).floorEntry(snap_id);
            return entry == null ? 0 : entry.getValue();
        }
    }
}