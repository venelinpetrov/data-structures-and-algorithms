package com.vpe;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {
    // 10 20 30 40
    // [10 20 0 0 0]
    //  ^a  ^b
    //      ^ab
    private final int[] items;
    private int front = 0;
    private int back = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        items[back] = value;
        back = (back + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        return items[front];
    }

    public boolean isEmpty() {
        return back == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", front=" + front +
                ", back=" + back +
                '}';
    }
}
