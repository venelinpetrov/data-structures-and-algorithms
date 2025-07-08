package com.vpe;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private int value;
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

    // addFirst
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

    // addLast
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

    // deleteFirst
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }

        if (first == last) {
            first = last = null;
        } else {
            first = first.next;

        }
        size--;
    }

    // deleteLast
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        // a->b->c
        if (first == last) {
            first = last = null;
        } else {
            var current = first;
            while (current.next != last) {
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        size--;
    }

    // contains
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // indexOf
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

    // toString
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


    public int getSize() {
        return size;
    }
}
