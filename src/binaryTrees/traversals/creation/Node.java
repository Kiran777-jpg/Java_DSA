package binaryTrees.traversals.creation;

public class Node {
    public int data;
    public Node left;
    public Node right;

    Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }


    Node(int data) {
        this.data=data;
        left=right=null;
    }
};
