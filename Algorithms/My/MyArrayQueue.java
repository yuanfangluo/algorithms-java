package Algorithms.My;

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
