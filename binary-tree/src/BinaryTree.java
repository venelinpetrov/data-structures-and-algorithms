import java.util.ArrayList;

public class BinaryTree {
    private Node root;

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(this.value);
        }
    }

    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root);
    }

    public ArrayList<Integer> findNodesAtDistance(int n) {
        var arr = new ArrayList<Integer>();
        findNodesAtDistance(root, n, arr);
        return arr;
    }

    private void findNodesAtDistance(Node node, int n, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        if (n == 0) {
            arr.add(node.value);
            return;
        }
        findNodesAtDistance(node.leftChild, n - 1, arr);
        findNodesAtDistance(node.rightChild, n - 1, arr);
    }

    public boolean isBinary() {
        return isBinary(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinary(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }

        return
            isBinary(node.leftChild, min, node.value - 1)
            && isBinary(node.rightChild, node.value + 1, max);
    }

    public boolean equals(BinaryTree tree) {
        if (tree == null) {
            return false;
        }
        return equals(tree.root, root);
    }

    private boolean equals (Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first != null && second != null) {
            return first.value == second.value
                && equals(first.leftChild, second.leftChild)
                && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    public int min(boolean isBinarySearchTree) {
        if (isBinarySearchTree) {
            return minBinarySearchTree(root);
        }
        return min();
    }

    private int minBinarySearchTree(Node root) {
        if (root == null) {
            throw new IllegalStateException();
        }
        int min;
        var node = root;
        do {
            min = node.value;
            node = node.leftChild;
        } while (node != null);

        return min;
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == node.rightChild;
    }
}
