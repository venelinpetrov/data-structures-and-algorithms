# Dynamic Array

This project contains a custom implementation of a **dynamic array** in Java. It resizes automatically when it runs out of space, supports common array operations, and provides utility methods like reverse and intersection.

---

## Class: `Array`

- Internally stores elements in a fixed-size `int[]`
- Automatically resizes the internal array when needed
- Tracks the current count of elements

---

## Supported Operations

| Method            | Description                                        | Time Complexity |
|-------------------|----------------------------------------------------|-----------------|
| `insert(int)`     | Appends an item to the end (with resize if needed) | **O(1)** amortized, **O(n)** worst |
| `insertAt(int, index)` | Inserts an item at a given index, shifts items | **O(n)**        |
| `delete(int)`     | Deletes an item at a given index, shifts items     | **O(n)**        |
| `indexOf(int)`    | Returns index of the given item, or -1 if not found| **O(n)**        |
| `getAt(int)`      | Returns item at the specified index                | **O(1)**        |
| `intersect(Array)`| Returns a new Array with common elements           | **O(n²)** naive implementation |
| `reverse()`       | Reverses the array in-place                        | **O(n)**        |
| `max()`           | Returns the maximum value in the array             | **O(n)**        |
| `printItems()`    | Prints all elements                                | **O(n)**        |

---

## Time Complexity Notes

- **Amortized O(1) insertion**: The `insert()` method doubles the array size when full, which makes most insertions fast.
- **`intersect()` is O(n²)** because it uses nested loops and `indexOf` on each element. Could be improved with hashing.
- **`insertAt()` and `delete()`** require shifting elements, so they are linear time.

---

## Example Usage

```java
Array array = new Array(3);
array.insert(10);
array.insert(20);
array.insert(30);
array.insert(40); // triggers resize

array.printItems(); // 10 20 30 40

array.delete(1); // removes 20

System.out.println(array.indexOf(30)); // 1
System.out.println(array.getAt(0));    // 10

array.reverse(); // now 40 30 10

Array other = new Array(3);
other.insert(30);
other.insert(50);

Array common = array.intersect(other); // [30]
common.printItems();
