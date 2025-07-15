package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class ChildrenSumProperty {

    private static int dfs(Node root) {
        if(root==null) return 0;
       int l=(root.left!=null)?root.left.data:0;
       int r=(root.right!=null)?root.right.data:0;

       if(l+r<root.data) {
           if(root.left!=null) root.left.data=root.data;
           if(root.right!=null) root.right.data=root.data;
       }

       l=dfs(root.left);
       r=dfs(root.right);
       if(root.left==null && root.right==null) return root.data;
       return root.data=l+r;
    }

    private static void childrenSum(Node root) {
        int rootVal=dfs(root);
        System.out.println(rootVal);

        //Testing
        BinaryTreeCreation.preorder(root);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
        childrenSum(root);
    }
}
