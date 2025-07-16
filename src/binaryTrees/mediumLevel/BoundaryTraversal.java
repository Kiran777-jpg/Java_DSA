package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private static void leftBoundary(Node root, List<Integer> ans) {
        while(root!=null) {
            if(root.left==null && root.right==null) break;
            ans.add(root.data);
            if(root.left!=null)
                root=root.left;
            else
                root=root.right;
        }
    }

    private static void leafNodes(Node root, List<Integer> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null)
            ans.add(root.data);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    private static void rightBoundary(Node root, List<Integer> ans) {
        List<Integer> temp=new ArrayList<>();
        while(root!=null) {
            if(root.left==null && root.right==null) break;
            temp.add(root.data);
            if(root.right!=null)
                root=root.right;
            else
                root=root.left;
        }
        for(int i=temp.size()-1;i>=0;i--)
            ans.add(temp.get(i));
    }

    private static void boundaryTraversal(Node root) {
        List<Integer> ans=new ArrayList<>();
        ans.add(root.data);
        leftBoundary(root.left, ans);
        leafNodes(root, ans);
        int size=ans.size();
        rightBoundary(root.right, ans);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
        boundaryTraversal(root);  // TC: O(n), SC: O(n)
    }
}
