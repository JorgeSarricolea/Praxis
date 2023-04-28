// Tree program where it gives me the options to create, insert, delete and perform the routes.

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    private static Scanner scanner = new Scanner(System.in);
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void create() {
        System.out.println("Enter root node:");
        int data = scanner.nextInt();
        root = new Node(data);
        create(root);
    }

    private void create(Node current) {
        System.out.println("Enter left child of " + current.data + ": (or -1 to skip)");
        int leftData = scanner.nextInt();
        if (leftData != -1) {
            current.left = new Node(leftData);
            create(current.left);
        }
        System.out.println("Enter right child of " + current.data + ": (or -1 to skip)");
        int rightData = scanner.nextInt();
        if (rightData != -1) {
            current.right = new Node(rightData);
            create(current.right);
        }
    }

    public void insert() {
        System.out.println("Enter data to insert:");
        int data = scanner.nextInt();
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            current = new Node(data);
            return current;
        }
        if (data < current.data) {
            current.left = insert(current.left, data);
        } else if (data > current.data) {
            current.right = insert(current.right, data);
        }
        return current;
    }

    public void delete() {
        System.out.println("Enter data to delete:");
        int data = scanner.nextInt();
        root = delete(root, data);
    }

    private Node delete(Node current, int data) {
        if (current == null) {
            return current;
        }
        if (data < current.data) {
            current.left = delete(current.left, data);
        } else if (data > current.data) {
            current.right = delete(current.right, data);
        } else {
            // Case 1: No child or only one child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // Case 2: Two children
            current.data = minValue(current.right);
            current.right = delete(current.right, current.data);
        }
        return current;
    }

    private int minValue(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public void preOrderTraversal() {
        System.out.println("Pre-order traversal:");
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    public void inOrderTraversal() {
        System.out.println("In-order traversal:");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node current) {
        if (current != null) {
            inOrderTraversal(current.left);
            System.out.print(current.data + " ");
            inOrderTraversal(current.right);
        }
    }

    public void postOrderTraversal() {
        System.out.println("Post-order traversal:");
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node current) {
        if (current != null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.print(current.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        while (true) {
            System.out.println("Binary Tree Operations:");
            System.out.println("1. Create");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Pre-order Traversal");
            System.out.println("5. In-order Traversal");
            System.out.println("6. Post-order Traversal");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            // User options
            switch (choice) {
                case 1:
                    binaryTree.create();
                    break;
                case 2:
                    binaryTree.insert();
                    break;
                case 3:
                    binaryTree.delete();
                    break;
                case 4:
                    binaryTree.preOrderTraversal();
                    break;
                case 5:
                    binaryTree.inOrderTraversal();
                    break;
                case 6:
                    binaryTree.postOrderTraversal();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}