package binaryTrees.traversals.creation;

import java.util.Scanner;

public class BinaryTreeCreation {

    public static Node buildTree() {
        int data;
        Scanner sc = new Scanner(System.in);
        data=sc.nextInt();
        if(data==-1) return null;
        Node newNode = new Node(data);
        System.out.println("left: " + newNode.data);
        newNode.left = buildTree();
        System.out.println("right: " + newNode.data);
        newNode.right = buildTree();
        return newNode;
    }

    public static void preorder(Node root) {
        if(root==null) return;
        System.out.print(root.data + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node buildTree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(root.data);
        preorder(root);
    }
}
