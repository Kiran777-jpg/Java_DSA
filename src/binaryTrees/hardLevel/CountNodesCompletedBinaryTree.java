package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class CountNodesCompletedBinaryTree {

    private static int dfs(Node root) {
        if(root==null) return 0;

        int l=heightLeftTree(root);
        int r=heightRightTree(root);

        if(l==r) return (1 << l) - 1;

        return 1+dfs(root.left)+dfs(root.right);
    }

    private static int heightRightTree(Node root) {
        int height=0;
        while(root!=null) {
            height++;
            root=root.right;
        }
        return height;
    }

    private static int heightLeftTree(Node root) {
        int height=0;
        while(root!=null) {
            height++;
            root=root.left;
        }
        return height;
    }

    private static void countNodesCompleteBinaryTree(Node root) {
        int ans=dfs(root);
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree4();
        countNodesCompleteBinaryTree(root);
    }
}
