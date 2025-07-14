package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBalancedTree {
    private static int isBalanced(Node root) {
        if (root == null) return 0;
        int l = isBalanced(root.left);
        if(l==-1) return -1;
        int r = isBalanced(root.right);
        if(Math.abs(l-r)>1 || r==-1) return -1;
        return Math.max(l, r)+1;
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        System.out.println(isBalanced(root));  // TC: O(n), SC: O(H) -> recursion stack space
    }
}
