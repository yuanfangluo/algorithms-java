package Algorithms.数据结构及排序.手把手带你实现动态数组;

public class MyArrayList<E> {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
    }

    // 底层真正存储数据的静态数组
    private E[] data;
    // 记录当前数组中有效元素的个数
    private int size;

    final static int DEFAULT_CAPACITY = 10;

    // 不带参数的构造方法
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 带元素个数的参数的构造方法
    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 增
    public void add(E e) {
        addLast(e);
    }

    // 在最后面添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在指定位置添加一个元素
    public void add(int index, E e) {
        // 检查索引越界
        checkPositionIndex(index);

        int n = data.length;
        if (size == n) {
            resize(size * 2);
        }

        // 将 index 位置及其后面的元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // 将元素添加到 index 位置
        data[index] = e;
        size++;
    }

    // 3、在头部位置增加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 删
    // 删除指定位置的元素
    public E remove(int index) {
        // 检查索引是否越界
        checkElementIndex(index);

        // 判断是否缩容
        int capacity = data.length;
        if (size == capacity / 4) {
            resize(capacity / 2);
        }

        // 获取要删除的元素
        E e = data[index];

        // 将 index 位置及其后面的元素向前移动一位
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // 将最后一个元素置为 null
        data[size - 1] = null;
        size--;
        return e;
    }

    // 删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 改
    public E set(int index, E e) {
        // 检查索引是否越界
        checkElementIndex(index);

        // 获取要修改的元素
        E old = data[index];

        // 修改元素
        data[index] = e;

        return old;
    }

    // 查
    public E get(int index) {
        // 检查索引是否越界
        checkElementIndex(index);

        return data[index];
    }

    // 工具方法
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 检查 index 索引位置是否可以添加元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查 index 索引位置是否可以存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

}
