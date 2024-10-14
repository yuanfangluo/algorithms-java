package Algorithms.数据结构及排序.手把手带你实现二叉堆;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity + 1]; // 索引 0 空着不用，所以多分配一个空间
        size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 父节点的索引
    private int parent(int node) {
        return node / 2;
    }

    // 左子节点的索引
    private int left(int node) {
        return node * 2;
    }

    // 右子节点的索引
    private int right(int node) {
        return node * 2 + 1;
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return heap[1];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(T x) {
        // 扩容
        if (size == heap.length - 1) {
            resize(2 * heap.length);
        }
        // 把新元素放到最后
        heap[++size] = x;
        // 然后上浮到正确位置
        swim(size);
    }

    // 删，删除堆顶元素，时间复杂度 O(logN)
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        T res = heap[1];
        // 把堆底元素放到堆顶
        swap(1, size--);
        // 然后下沉到正确位置
        sink(1);
        // 避免对象游离
        heap[size + 1] = null;
        // 缩容
        if ((size > 0) && (size == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }

    // 上浮操作，时间复杂度是树高 O(logN)
    private void swim(int k) {
        while (k > 1 && comparator.compare(heap[parent(k)], heap[k]) > 0) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    // 下沉操作，时间复杂度是树高 O(logN)
    private void sink(int k) {
        while (left(k) <= size) {
            int j = left(k);
            if (j < size && comparator.compare(heap[j], heap[j + 1]) > 0)
                j++;
            if (comparator.compare(heap[k], heap[j]) <= 0)
                break;
            swap(k, j);
            k = j;
        }
    }

    // 调整堆的大小
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        assert capacity > size;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(3, Comparator.naturalOrder());
        pq.push(3);
        pq.push(1);
        pq.push(4);
        pq.push(1);
        pq.push(5);
        pq.push(9);
        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}