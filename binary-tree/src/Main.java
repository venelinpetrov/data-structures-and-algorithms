//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var tree = new BinaryTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(6));
        System.out.println(tree.find(1));
        System.out.println(tree.find(11));
        System.out.println(tree.find(7));
        System.out.println(tree.find(8));
        System.out.println("Done");
        tree.traversePreOrder();
        System.out.println("------------");
        tree.traverseInOrder();
        System.out.println("------------");
        tree.traversePostOrder();
        System.out.println("------------");
        System.out.println(tree.height());
        System.out.println("------min------");
        System.out.println(tree.min());
        System.out.println("------min bst------");
        System.out.println(tree.min(true));
        System.out.println("-----eq-----");

        var tree2 = new BinaryTree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println(tree.equals(tree2));

        System.out.println("------isBinary------");
        System.out.println(tree.isBinary());
        System.out.println("------findNodesAtDistance------");

        for (var item : tree.findNodesAtDistance(1)) {
            System.out.println(item);
        }
    }
}