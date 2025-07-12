package com.vpe;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    public HashTable() {
        items = new LinkedList[50];
    }

    public HashTable(int initialCapacity) {
        items = new LinkedList[initialCapacity];
    }

    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private LinkedList<Entry>[] items;

    public void put(int key, String value) {
        var index = hash(key);

        if (items[index] == null) {
            items[index] = new LinkedList<>();
        }

        for (var item : items[index]) {
            if (item.key == key) {
                item.value = value;
                return;
            }
        }
        items[index].addLast(new Entry(key, value));
        size++;

        if ((double) size / items.length > LOAD_FACTOR) {
            resize();
        }
    }

    public String get(int key) {
        var index = hash(key);

        if (items[index] == null) {
            return null;
        }

        for (var item : items[index]) {
            if(item.key == key) {
                return item.value;
            }
        }

        return null;
    }

    public void remove(int key) {
        var index = hash(key);

        if(items[index] == null) {
            throw new IllegalStateException();
        }

        var iterator = items[index].iterator();

        while(iterator.hasNext()) {
            var item = iterator.next();
            if (item.key == key) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    private int hash(int key) {
        return key % items.length;
    }

    private void resize() {
        var oldItems = items;
        items = new LinkedList[oldItems.length * 2];
        size = 0;

        for (var bucket : oldItems) {
            if (bucket != null) {
                for (var item : bucket) {
                    put(item.key, item.value);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
