# LinkedList

This is a custom implementation of a **singly linked list** in Java. It supports basic list operations like adding, deleting, searching, and indexing elements.

## Structure

Each element in the list is stored in a `Node`, which contains:

- `value`: the integer value
- `next`: reference to the next node

The list itself maintains:

- `first`: reference to the first node
- `last`: reference to the last node
- `size`: keeps track of the linked list size

## Supported Operations

| Method           | Description                            | Time Complexity |
|------------------|----------------------------------------|-----------------|
| `addFirst(int)`  | Inserts a value at the beginning       | `O(1)`          |
| `addLast(int)`   | Inserts a value at the end             | `O(1)`          |
| `deleteFirst()`  | Removes the first element              | `O(1)`          |
| `deleteLast()`   | Removes the last element               | `O(n)`          |
| `contains(int)`  | Checks if a value exists in the list   | `O(n)`          |
| `indexOf(int)`   | Returns the index of a given value     | `O(n)`          |
| `size()`         | Returns the size of the linked list    | `O(1)`          |
| `toArray()`      | Converts the linked list to an array   | `O(n)`          |

## Notes on Complexity

- **`addFirst` and `deleteFirst`** are constant time (`O(1)`) because they only involve direct pointer reassignments.
- **`addLast`** is `O(1)` because the list maintains a `last` pointer.
- **`deleteLast`** is linear time (`O(n)`) because it must traverse the list to find the node before the last one.
- **`contains` and `indexOf`** are also `O(n)` because they require scanning through the list.

## Memory Management

Extra care is taken in `deleteFirst()` and `deleteLast()` to nullify internal references. This helps the garbage collector reclaim memory promptly and avoids unintentional memory retention.

## Potential Improvements

- Add support for **generics** instead of using `int`
- Add iterator support
- Convert to a **doubly linked list** if bidirectional access is needed

## Example Usage

```java
LinkedList list = new LinkedList();

list.addFirst(10);
list.addLast(20);
list.addFirst(5);

System.out.println(list.contains(10)); // true
System.out.println(list.indexOf(20));  // 2

list.deleteFirst();
list.deleteLast();
