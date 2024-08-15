package Algorithms.数据结构基础.手把手带你实现队列和栈.用数组实现队列和栈;

import Algorithms.数据结构基础.手把手带你实现队列和栈.环形数组.CycleArray;

public class MyArrayQueue<E> {
    private CycleArray<E> arr;

    public MyArrayQueue() {
        arr = new CycleArray<>();
    }

    public void push(E t) {
        arr.addLast(t);
    }

    public E pop() {
        return arr.removeFirst();
    }

    public E peek() {
        return arr.getFirst();
    }

    public int size() {
        return arr.size();
    }
}
