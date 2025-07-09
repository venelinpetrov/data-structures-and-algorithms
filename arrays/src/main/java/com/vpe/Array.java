package com.vpe;

public class Array {
    private int[] items;
    private int size;

    public Array(int size) {
        items = new int[size];
    }

    public void insert(int item) {
        if (items.length == size) {
            int[] copy = new int[size * 2];

            for (int i = 0; i < size; i++) {
                copy[i] = items[i];
            }

            items = copy;
        }

        items[size++] = item;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }

        size--;
    }

    public int indexOf(int item) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                index = i;
                return i;
            }
        }

        return index;
    }

    public void printItems() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }

    public int getAt(int index) {
        return items[index];
    }

    public Array intersect(Array other) {
        Array smaller = this.size <= other.size ? this : other;
        Array larger = this.size > other.size ? this : other;

        if (other.size == 0) {
            return new Array(0);
        }

        int minLength = Math.min(this.size, other.size);

        Array result = new Array(minLength);

        for (int i = 0; i < minLength; i++) {
            int item = smaller.getAt(i);

            if (larger.indexOf(item) > -1 && result.indexOf(item) == -1) {
                result.insert(item);
            }
        }

        return result;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int tmp = items[i];
            items[i] = items[size - 1 - i];
            items[size - 1 - i] = tmp;
        }
    }

    public int max() throws IllegalStateException {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty");
        }

        int maxValue = items[0];

        for (int i = 1; i < size; i++) {
            if (items[i] > maxValue) {
                maxValue = items[i];
            }
        }

        return maxValue;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (size == items.length) {
            int[] copy = new int[size * 2];
            for (int i = 0; i < size; i++) {
                copy[i] = items[i];
            }
            items = copy;
        }

        for (int i = size - 1; i >= index ; i--) {
            items[i + 1] = items[i];
        }

        items[index] = item;
        size++;
    }
}
