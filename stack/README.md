# Stack

This is a basic implementation of a **generic Stack** in Java. It provides common stack operations such as push, pop, peek, checking if the stack is empty, and querying its size. Internally, it uses a `LinkedList<T>` for efficient O(1) stack operations.

## Structure

The `Stack<T>` class wraps a `LinkedList<T>` and supports generic data types.

## Operations and Time Complexity

| Method            | Description                                      | Time Complexity |
|-------------------|--------------------------------------------------|-----------------|
| `push(T item)`    | Adds an item to the top of the stack             | O(1)            |
| `pop()`           | Removes and returns the top item                 | O(1)            |
| `peek()`          | Returns the top item without removing it         | O(1)            |
| `isEmpty()`       | Checks if the stack is empty                     | O(1)            |
| `size()`          | Returns the number of elements in the stack      | O(1)            |

## Notes

- The stack uses `addLast()` and `removeLast()` to ensure efficient end-of-list operations.
- `peek()` and `pop()` throw a `NoSuchElementException` if the stack is empty.
- Generics allow it to be used with any object type (e.g., `Stack<Integer>`, `Stack<String>`).

## Limitations

- This stack is **not thread-safe**. Synchronization must be added externally if used in concurrent environments.
- No maximum capacity or overflow protection is enforced.
- No support for iteration (though it could be added via `Iterable<T>`).

## How to Use

```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());   // 30
System.out.println(stack.peek());  // 20
System.out.println(stack.size());  // 2
System.out.println(stack.isEmpty()); // false
```