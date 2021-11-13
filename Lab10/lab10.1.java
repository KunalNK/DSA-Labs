// Checking if a binary tree is a complete binary tree in Java

// Node creation
class Node3 {
    int data;
    Node3 left, right;

    Node3(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree3 {
    Node3 root;

    // Count the number of nodes
    int countNumNodes(Node3 root) {
        if (root == null)
            return (0);
        return (1 + countNumNodes(root.left) + countNumNodes(root.right));
    }

    // Check for complete binary tree
    boolean checkComplete(Node3 root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (checkComplete(root.left, 2 * index + 1, numberNodes)
                && checkComplete(root.right, 2 * index + 2, numberNodes));
    }

    public static void main(String args[]) {
        BinaryTree3 tree = new BinaryTree3();

        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.right = new Node3(5);
        tree.root.left.left = new Node3(4);
        tree.root.right.left = new Node3(6);

        int node_count = tree.countNumNodes(tree.root);
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");
    }
}
