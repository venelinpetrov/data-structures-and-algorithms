package com.vpe;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }

        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }

        if (first == last) {
            first = last = null;
        } else {
            var current = first;
            while (current.next != last) {
                current = current.next;
            }
            last.next = null;
            last = current;
        }

        size--;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        var current = first;
        var index = 0;

        while(current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node current = first;
        String str = "";

        while(current != null) {
            str += current + "\n";
            current = current.next;
        }

        return str;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public Node getLast() {
        return last;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while(current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        // 10 -> 20 -> 30 -> 40
        // p     c     n
        // ---
        // 10 <- 20 <- 30 <- 40
        //                    p     c     n (we stop here)
        if (isEmpty()) {
            return;
        }

        Node prev = first;
        var cur = first.next;

        while(cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        last = first;
        last.next = null;
        first = prev;
    }

    public Node getPrev(Node node) {
        if (isEmpty()) {
            return null;
        }

        if (first == last) {
            return null;
        }

        var current = first;

        while (current.next != node) {
            current = current.next;
        }

        return current;
    }
}
