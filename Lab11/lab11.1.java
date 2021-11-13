
// Checking if a binary tree is height balanced in Java

// Node creation
class Node3 {

    int data;
    Node3 left, right;

    Node3(int d) {
        data = d;
        left = right = null;
    }
}

// Calculate height
class Height {
    int height = 0;
}

class BinaryTree3 {

    Node3 root;

    // Check height balance
    boolean checkHeightBalance(Node3 root, Height height) {

        // Check for emptiness
        if (root == null) {
            height.height = 0;
            return true;
        }

        Height leftHeighteight = new Height(), rightHeighteight = new Height();
        boolean l = checkHeightBalance(root.left, leftHeighteight);
        boolean r = checkHeightBalance(root.right, rightHeighteight);
        int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

        height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

        if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
            return false;

        else
            return l && r;
    }

    public static void main(String args[]) {
        Height height = new Height();

        BinaryTree3 tree = new BinaryTree3();
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);

        if (tree.checkHeightBalance(tree.root, height))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}
