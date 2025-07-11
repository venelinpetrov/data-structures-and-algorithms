package com.vpe;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);

        reverse(q);
        System.out.println(q);

        var q2 = new ArrayQueue(4);
        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueue(30);
        System.out.println(q2);
        System.out.println(q2.dequeue());
        System.out.println(q2);
        q2.enqueue(40);
        System.out.println(q2);
        q2.enqueue(50);
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        q2.enqueue(10);
        System.out.println(q2);

        System.out.println("---Priority queue---");
        var pq = new PriorityQueue(5);
        pq.add(4);
        pq.add(2);
        pq.add(5);
        System.out.println(pq);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        var stack = new Stack<Integer>();

        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while(!stack.empty()) {
            queue.add(stack.pop());
        }
    }
}
