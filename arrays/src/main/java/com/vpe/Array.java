package com.vpe;

public class Array {
    private int[] items;
    private int count;

    public Array(int size) {
        items = new int[size];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] copy = new int[count * 2];
            for (int i = 0; i < count; i++) {
                copy[i] = items[i];
            }
            items = copy;
        }
        items[count++] = item;
    }

    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int item) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                index = i;
                return i;
            }
        }

        return index;
    }

    public void printItems() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public int getAt(int index) {
        return items[index];
    }

    public Array intersect(Array other) {
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

    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            int tmp = items[i];
            items[i] = items[count - 1 - i];
            items[count - 1 - i] = tmp;
        }
    }

    public int max() throws IllegalStateException {
        if (this.count == 0) {
            throw new IllegalStateException("Array is empty");
        }

        int maxValue = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > maxValue) {
                maxValue = items[i];
            }
        }
        return maxValue;
    }

    public void insertAt(int item, int index) {
        // [1, 2, 3, 4]
        //     ^(1, 8)
        // [1, 8, 2, 3, 4]
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        if (count == items.length) {
            int[] copy = new int[count * 2];
            for (int i = 0; i < count; i++) {
                copy[i] = items[i];
            }
            items = copy;
        }
        //
        for (int i = count - 1; i >= index ; i--) {
            items[i + i] = items[i];
        }
        items[index] = item;
        count++;
    }
}
