package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class DiameterBinaryTree {
    private static int dfs(Node root, int[] ans) {
        if(root==null) return 0;
        int l=dfs(root.left, ans);
        int r=dfs(root.right, ans);
        ans[0]=Math.max(ans[0], l+r+1);
        return Math.max(l, r)+1;
    }
    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        int[] ans={Integer.MIN_VALUE};
        System.out.println(dfs(root, ans));  // TC: O(n), SC: O(1)
        System.out.println("Diameter: " + ans[0]);
    }
}
