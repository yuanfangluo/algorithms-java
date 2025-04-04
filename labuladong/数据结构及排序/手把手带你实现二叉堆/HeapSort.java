package labuladong.数据结构及排序.手把手带你实现二叉堆;

public class HeapSort {
    // 堆排序伪码，对 arr 原地排序
    // 时间复杂度 O(NlogN)，空间复杂度 O(N)
    int[] heapSort(int[] arr) {
        int[] res = new int[arr.length];
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(res.length, (a, b) -> (a - b));
        for (int x : arr)
            pq.push(x);
        // 元素出堆的顺序是有序的
        for (int i = 0; i < arr.length; i++)
            res[i] = pq.pop();
        return res;
    }
}
