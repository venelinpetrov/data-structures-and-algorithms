# HashTable

This is a basic implementation of a **Hash Table** in Java using separate chaining (via linked lists) to handle collisions. It supports insertion, retrieval, deletion, dynamic resizing based on load factor, and optional initial capacity configuration.

## Structure

Each entry in the table is stored in a `LinkedList` bucket. Every `Entry` object contains:
- An `int` key
- A `String` value

The internal array of buckets resizes when the load factor exceeds a threshold (default: `0.75`).

## Operations and time complexity

| Method                       | Description                                                         | Time Complexity          |
|---------------------------   |---------------------------------------------------------------------|--------------------------|
| `put(int key, String value)` | Adds or updates a key-value pair in the table                       | O(1) average, O(n) worst |
| `get(int key)`               | Retrieves the value associated with a key                           | O(1) average, O(n) worst |
| `remove(int key)`            | Removes a key-value pair from the table                             | O(1) average, O(n) worst |
| `resize()`                   | Doubles the table size and rehashes all existing entries            | O(n)                     |
| `hash(int key)`              | Maps a key to a bucket index using modular arithmetic               | O(1)                     |

## Notes

- The table resizes automatically when the load factor exceeds `0.75`.
- Collision resolution is handled using separate chaining (`LinkedList<Entry>` per bucket).
- Supports custom initial capacity via constructor: `new HashTable(int initialCapacity)`.

## Limitations

- Only supports `int` keys and `String` values (not generic).
- Not thread-safe (no concurrency protection).
- No iteration or keySet/entrySet views (as in `HashMap`).

## How to Use

```java
HashTable table = new HashTable();
table.put(1, "Apple");
table.put(2, "Banana");

System.out.println(table.get(1)); // Apple

table.remove(2);
System.out.println(table.get(2)); // null
