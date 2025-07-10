package com.vpe;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T> {
    private final LinkedList<T> items = new LinkedList<>();


    public void push(T el) {
        items.addLast(el);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.getLast();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
