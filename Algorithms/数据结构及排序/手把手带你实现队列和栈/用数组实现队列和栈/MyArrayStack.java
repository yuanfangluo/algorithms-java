package Algorithms.数据结构及排序.手把手带你实现队列和栈.用数组实现队列和栈;

import java.util.ArrayList;

public class MyArrayStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    // 向栈顶加入元素，时间复杂度 O(1)
    public void push(E e) {
        list.add(e);
    }

    // 从栈顶弹出元素，时间复杂度 O(1)
    public E pop() {
        return list.remove(list.size() - 1);
    }

    // 查看栈顶元素，时间复杂度 O(1)
    public E peek() {
        return list.get(list.size() - 1);
    }

    // 返回栈中的元素个数，时间复杂度 O(1)
    public int size() {
        return list.size();
    }
}
