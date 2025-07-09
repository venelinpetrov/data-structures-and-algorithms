# BinaryTree

This is a basic implementation of a **Binary Tree** in Java. It supports insertions, searches, traversal, equality checks, and utility methods such as checking if the tree is a valid binary search tree (BST), calculating height, and finding the minimum value.

## Structure

Each `Node` contains:
- An `int` value
- A left child reference
- A right child reference

## Operations and Time Complexity

| Method                      | Description                                                            | Time Complexity |
|----------------------------|------------------------------------------------------------------------|-----------------|
| `insert(int value)`        | Inserts a new node into the tree (as a BST)                            | O(log n) average, O(n) worst |
| `find(int value)`          | Checks if a value exists in the tree                                   | O(log n) average, O(n) worst |
| `equals(BinaryTree other)` | Checks structural and value equality between two trees                 | O(n)            |
| `traversePreOrder()`       | Prints values in pre-order traversal                                   | O(n)            |
| `traverseInOrder()`        | Prints values in in-order traversal                                    | O(n)            |
| `traversePostOrder()`      | Prints values in post-order traversal                                  | O(n)            |
| `findNodesAtDistance(n)`   | Returns a list of node values at distance `n` from the root            | O(n)            |
| `isBinary()`               | Verifies the tree maintains the binary search tree invariant           | O(n)            |
| `height()`                 | Returns the height of the tree                                         | O(n)            |
| `min()`                    | Returns the minimum value in a general binary tree                     | O(n)

## Notes

- All traversals are implemented recursively.
- The `equals` method uses a recursive comparison.
- `min(true)` traverses left children only, relying on the BST property.
- `findNodesAtDistance(n)` performs a level-order distance scan.
- `isBinary()` uses a recursive bounds check to ensure BST validity.

## Limitations

- This is not a self-balancing tree (like AVL or Red-Black Tree), so performance can degrade to O(n) in skewed trees.
- No delete operation is implemented.
- No iterative traversal methods (e.g., with stack or queue).

## How to Use

```java
BinaryTree tree = new BinaryTree();
tree.insert(10);
tree.insert(5);
tree.insert(15);

tree.traverseInOrder(); // prints: 5 10 15
System.out.println(tree.find(10)); // true
System.out.println(tree.min(true)); // 5