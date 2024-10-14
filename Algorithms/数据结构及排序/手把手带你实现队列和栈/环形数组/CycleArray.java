package Algorithms.数据结构及排序.手把手带你实现队列和栈.环形数组;

// 环形数组
// 左闭右开区间[staet, end)
public class CycleArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int size) {
        this.size = size;
        // 因为 Java 不支持直接创建泛型数组，所以这里使用了类型转换
        this.arr = (T[]) new Object[size];
        // start 指向第一个有效元素的索引，闭区间
        this.start = 0;
        // 切记 end 是一个开区间，
        // 即 end 指向最后一个有效元素的下一个位置索引
        this.end = 0;
        this.count = 0;
    }

    // 自动扩缩容辅助函数
    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        // 创建新的数组
        T[] newArr = (T[]) new Object[newSize];
        // 将旧数组的元素复制到新数组中
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        arr = newArr;
        // 重置 start 和 end 指针
        start = 0;
        end = count;
        size = newSize;
    }

    // 在数组头部添加元素，时间复杂度 O(1)
    public void addFirst(T val) {
        // 当数组满时，扩容为原来的两倍
        if (isFull()) {
            resize(size * 2);
        }
        // 因为 start 是闭区间，所以先左移，再赋值
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    // 删除数组头部元素，时间复杂度 O(1)
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // 因为 start 是闭区间，所以先赋值，再右移
        T oldValue = arr[start];
        arr[start] = null;
        start = (start + 1) % size;
        count--;
        // 如果数组元素数量减少到原大小的四分之一，则减小数组大小为一半
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
        return oldValue;
    }

    // 在数组尾部添加元素，时间复杂度 O(1)
    public void addLast(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        // 因为 end 是开区间，所以是先赋值，再右移
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    // 删除数组尾部元素，时间复杂度 O(1)
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // 因为 end 是开区间，所以先左移，再赋值
        end = (end - 1 + size) % size;
        T oldValue = arr[end];
        arr[end] = null;
        count--;
        // 缩容
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
        return oldValue;
    }

    // 获取数组头部元素，时间复杂度 O(1)
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }

    // 获取数组尾部元素，时间复杂度 O(1)
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // end 是开区间，指向的是下一个元素的位置，所以要减 1
        return arr[(end - 1 + size) % size];
    }

    public boolean isFull() {
        return count == size;
    }
    
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
