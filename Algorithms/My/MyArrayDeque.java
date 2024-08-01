package Algorithms.My;

public class MyArrayDeque<E> {
    private CycleArray<E> arr = new CycleArray<>();

    // 从队头插入元素，时间复杂度 O(1)
    void addFirst(E e) {
        arr.addFirst(e);
    }

    // 从队尾插入元素，时间复杂度 O(1)
    void addLast(E e) {
        arr.addLast(e);
    }

    // 从队头删除元素，时间复杂度 O(1)
    E removeFirst() {
        return arr.removeFirst();
    }

    // 从队尾删除元素，时间复杂度 O(1)
    E removeLast() {
        return arr.removeLast();
    }

    // 查看队头元素，时间复杂度 O(1)
    E peekFirst() {
        return arr.getFirst();
    }

    // 查看队尾元素，时间复杂度 O(1)
    E peekLast() {
        return arr.getLast();
    }
}
