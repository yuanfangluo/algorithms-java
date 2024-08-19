package Algorithms.数据结构基础.手把手带你实现二叉堆;

import java.util.Arrays;

public class SimpleMinPQ {
    // 增：push 方法插入元素
    // 以小顶堆为例，向小顶堆中插入新元素遵循两个步骤：
    // 1、先把新元素追加到二叉树底层的最右侧，保持完全二叉树的结构。
    // 此时该元素的父节点可能比它大，不满足小顶堆的性质。
    // 2、为了恢复小顶堆的性质，需要将这个新元素不断上浮（swim），直到它的父节点比它小为止，
    // 或者到达根节点。此时整个二叉树就满足小顶堆的性质了。

    // 删：pop 方法删除堆顶元素
    // 以小顶堆为例，删除小顶堆的堆顶元素遵循两个步骤：
    // 1、先把堆顶元素删除，把二叉树底层的最右侧元素摘除并移动到堆顶，保持完全二叉树的结构。
    // 此时堆顶元素可能比它的子节点大，不满足小顶堆的性质。
    // 2、为了恢复小顶堆的性质，需要将这个新的堆顶元素不断下沉（sink），直到它的子节点比它小为止，
    // 或者到达叶子节点。此时整个二叉树就满足小顶堆的性质了。

    // 在数组上模拟二叉树

    public static void main(String[] args) {
        SimpleMinPQ minPQ = new SimpleMinPQ(10);
        minPQ.push(2);
        System.out.println(Arrays.toString(minPQ.heap));
        minPQ.push(2);
        System.out.println(Arrays.toString(minPQ.heap));
    }

    private final int[] heap;
    private int size;

    public SimpleMinPQ(int capacity) {
        // 索引 0 空着不用，所以多分配一个空间
        heap = new int[capacity + 1];
        size = 0;
    }

    public int size() {
        return size;
    }

    // 父节点的索引
    int parent(int node) {
        return node / 2;
    }

    // 左子节点的索引
    int left(int node) {
        return node * 2;
    }

    // 右子节点的索引
    int right(int node) {
        return node * 2 + 1;
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public int peek() {
        // 索引 0 空着不用，所以堆顶元素是索引 1
        return heap[1];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(int x) {
        // 把新元素放到最后
        heap[++size] = x;
        // 然后上浮到正确位置
        swim(size);
    }

    // 删，删除堆顶元素，时间复杂度 O(logN)
    public int pop() {
        int res = heap[1];
        // 把堆底元素放到堆顶
        heap[1] = heap[size--];
        // 然后下沉到正确位置
        sink(1);
        return res;
    }

    // 上浮操作，时间复杂度是树高 O(logN)
    private void swim(int x) {
        // 如果当前节点的父节点的值大于本身，需要和父节点交换位置
        while (x > 1 && heap[parent(x)] > heap[x]) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    // 下沉操作，时间复杂度是树高 O(logN)
    private void sink(int x) {

        while (left(x) <= size || right(x) <= size) {
            int min = x;
            // 先比较左右子节点，哪个更小，就和哪个交换
            if (left(x) <= size && heap[left(x)] < heap[min]) {
                min = left(x);
            }
            if (right(x) <= size && heap[right(x)] < heap[min]) {
                min = right(x);
            }
            // 如果 min 还是 x，说明 x 已经是最小的了，不需要再下沉了
            if (min == x) {
                break;
            }

            swap(x, min);
            x = min;
        }
    }

}
