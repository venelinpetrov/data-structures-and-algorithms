package com.vpe;

import java.util.Stack;

public class QueueWithTwoStacks {
    // <-10 20 30 40<-
    // [10 20 30 40]-> [40 30 20 10] -> 10 20 30 40
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        s1.push(value);
    }

    public int deque() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
