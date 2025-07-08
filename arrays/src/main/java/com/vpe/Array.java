package com.vpe;

public class Array {
    private int[] arr;
    private int count;
    public Array(int size) {
        arr = new int[size];
    }

    public void insert(int item) {
        if (arr.length == count) {
            int[] copy = new int[count * 2];
            for (int i = 0; i < count; i++) {
                copy[i] = arr[i];
            }
            arr = copy;
        }
        arr[count++] = item;
    }

    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            arr[i] = arr[i + 1];
        }

        count--;
    }

    public int indexOf(int item) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (arr[i] == item) {
                index = i;
                return i;
            }
        }

        return index;
    }

    public void printItems() {
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }
}
