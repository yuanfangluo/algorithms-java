package Algorithms.My;

import java.util.LinkedList;

public class MyLinkedQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    // 向队尾插入元素，时间复杂度 O(1)
    public void push(E e) {
        list.addLast(e);
    }

    // 从队头删除元素，时间复杂度 O(1)
    public E pop() {
        return list.removeFirst();
    }

    // 查看队头元素，时间复杂度 O(1)
    public E peek() {
        return list.getFirst();
    }

    // 返回队列中的元素个数，时间复杂度 O(1)
    public int size() {
        return list.size();
    }
}
