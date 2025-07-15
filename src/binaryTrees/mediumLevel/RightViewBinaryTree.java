package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {

    private static void recursion(Node root, int level, List<Integer> ans) {
        if(root==null)
            return;
        if(ans.size()==level) ans.add(root.data);
        recursion(root.right, level+1, ans);
        recursion(root.left, level+1, ans);
    }
    private static void rightSideViewRecursion(Node root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, 0, ans);
        System.out.println(ans);
    }

    private static void rightViewBfs(Node root) {
        List<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size=q.size();
            boolean flag=true;
            while((size--)>0) {
                root=q.remove();
                if(flag) {
                    ans.add(root.data);
                    flag=false;
                }
                if(root.right!=null)
                    q.add(root.right);
                if(root.left!=null)
                    q.add(root.left);
            }
        }
        System.out.println("leftView: " + ans);
    }
    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root=BinaryTreeCreation.buildTree2();
        rightViewBfs(root);  // TC: O(n), SC: O(H)
        rightSideViewRecursion(root);
    }
}
