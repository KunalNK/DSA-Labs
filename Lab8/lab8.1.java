
// Checking if a binary tree is a full binary tree in Java

class Node2 {
    int data;
    Node2 leftChild, rightChild;

    Node2(int item) {
        data = item;
        leftChild = rightChild = null;
    }
}

class BinaryTree2 {
    Node2 root;

    // Check for Full Binary Tree
    boolean isFullBinaryTree(Node2 node) {

        // Checking tree emptiness
        if (node == null)
            return true;

        // Checking the children
        if (node.leftChild == null && node.rightChild == null)
            return true;

        if ((node.leftChild != null) && (node.rightChild != null))
            return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));

        return false;
    }

    public static void main(String args[]) {
        BinaryTree2 tree = new BinaryTree2();
        tree.root = new Node2(1);
        tree.root.leftChild = new Node2(2);
        tree.root.rightChild = new Node2(3);
        tree.root.leftChild.leftChild = new Node2(4);
        tree.root.leftChild.rightChild = new Node2(5);
        tree.root.rightChild.leftChild = new Node2(6);
        tree.root.rightChild.rightChild = new Node2(7);

        if (tree.isFullBinaryTree(tree.root))
            System.out.print("The tree is a full binary tree");
        else
            System.out.print("The tree is not a full binary tree");
    }
}
