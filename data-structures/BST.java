class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST{
    Node root;

    // Insert a node into BST
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }
    Node searchBST(Node root, int val) {
        if (root == null || root.data == val) {
            return root;
        }

        if (val < root.data) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        int key = 81;
        Node result = tree.searchBST(tree.root, key);

        if (result != null)
            System.out.println("Value " + key + " Found");
        else
            System.out.println("Value " + key + " Not Found");
    }
}
