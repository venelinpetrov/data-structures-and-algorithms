package com.vpe;

import java.util.Arrays;

public class PriorityQueue {
    private final int[] items;
    int count = 0;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void add(int value) {
        if (count == items.length) {
            throw new IllegalStateException("Queue is full");
        }

        int i;

        for(i = count - 1; i >= 0; i--) {
            if (value < items[i]) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }

        items[i + 1] = value;
        count++;
    }

    public int remove() {
        if (!isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "items=" + Arrays.toString(items) +
                ", count=" + count +
                '}';
    }
}
