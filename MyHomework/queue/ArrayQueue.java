package MyHomework.queue;

import java.util.Arrays;

public class ArrayQueue<T> {
    int maxSize;
    int front = -1; // 指向第一个数据的前一个的指针
    int rear = -1; // 指向最后一个数据的指针
    T[] arr; // 存放数据的容器

    public T showHead() {
        if (isEmpty()) throw new RuntimeException("队列已空");
        return arr[front + 1];
    }

    public T[] show() {
        return Arrays.copyOfRange(arr, front + 1, rear + 1);
    }

    public boolean isEmpty() {
        return front == rear;
    }  // 没有数据时两者会重叠

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean add(T data) { // add本质上是移动rear指针
        if (isFull()) return false;
        arr[++ rear] = data;
        return true;
    }

    public T out() { // out本质上是移动front指针
        if (isEmpty()) throw new RuntimeException("队列已空");
        return arr[++ front];
    }

    public void removeAll() {
        front = -1;
        rear = -1;
    }

    public ArrayQueue(int size) {
        this.maxSize = size;
        arr = (T[])new Object[size];
    }
}
