package Algorithms.other;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _1146_快照数组 {
    public static void main(String[] args) {
         SnapshotArray obj = new SnapshotArray(3);
         obj.set(0,5);
         int param_2 = obj.snap();
         System.out.println(param_2);
         obj.set(0,6);
         int param_3 = obj.get(0,0);
        System.out.println(param_3);
    }
}

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