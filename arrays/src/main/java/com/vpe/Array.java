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

    public int getAt (int index) {
        return arr[index];
    }

    public Array intersect (Array other) {
        Array smaller = this.count <= other.count ? this : other;
        Array larger = this.count > other.count ? this : other;

        if (other.count == 0) {
            return new Array(0);
        }

        int minLength = Math.min(this.count, other.count);

        Array result = new Array(minLength);

        for (int i = 0; i < minLength; i++) {
            int item = smaller.getAt(i);
            if (larger.indexOf(item) > -1 && result.indexOf(item) == -1) {
                result.insert(item);
            }
        }

        return result;
    }
}
