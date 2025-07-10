package com.vpe;

import java.util.NoSuchElementException;

public class MinStack {
    private final Stack<Integer> mainStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek())  {
            minStack.push(value);
        }
    }

    public int pop() {
        if(mainStack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        var value = mainStack.pop();
        if (value.equals(minStack.peek())) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        return minStack.peek();
    }
}
