# Queue (see ArrayQueue.java)

This is a basic implementation of a **fixed-size, circular ArrayQueue** in Java. It supports typical queue operations such as enqueue, dequeue, peek, and checking if the queue is full or empty. Internally, it uses a circular array to ensure efficient O(1) operations.

## Structure

The `ArrayQueue` class manages elements using an integer array and circular indexing. It maintains three internal variables: `front`, `back`, and `count` to track the queue state.

## Operations and Time Complexity

| Method              | Description                                        | Time Complexity |
|---------------------|----------------------------------------------------|-----------------|
| `enqueue(int value)`| Adds an element to the end of the queue            | O(1)            |
| `dequeue()`         | Removes and returns the element at the front       | O(1)            |
| `peek()`            | Returns the element at the front without removing  | O(1)            |
| `isEmpty()`         | Checks if the queue has no elements                | O(1)            |
| `isFull()`          | Checks if the queue has reached its capacity       | O(1)            |

## Notes

- The implementation uses modulo arithmetic to wrap around the internal array for efficient use of space.
- `enqueue()` throws an `IllegalStateException` if the queue is full.
- `dequeue()` and `peek()` throw a `NoSuchElementException` if the queue is empty.
- The queue does not automatically resize; its capacity is fixed upon construction.

## Limitations

- This queue is **not thread-safe**. Use appropriate synchronization if used concurrently.
- Does not support dynamic resizing. To handle arbitrary-sized input, consider using a dynamically resizing queue or `java.util.Queue`.
- Currently supports only `int` values. Generic support could be added if needed.

## How to Use

```java
ArrayQueue queue = new ArrayQueue(5);
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

System.out.println(queue.dequeue()); // 10
System.out.println(queue.peek());    // 20
System.out.println(queue.isFull());  // false
System.out.println(queue.isEmpty()); // false
