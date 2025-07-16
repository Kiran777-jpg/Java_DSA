package binaryTrees.traversals;


import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    private static void preorder(Node root) {
        if(root==null) return;
        System.out.print(root.data + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void iterativePreorder(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> preorder=new ArrayList<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.pop();
            preorder.add(node.data);
            if(node.right!=null)
                st.push(node.right);
            if(node.left!=null)
                st.push(node.left);
        }
        System.out.println(preorder);
    }

    public static void main(String[] args) {
//        Node root = BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        preorder(root); // TC: O(3*n), SC: O(N)
        System.out.println();
        iterativePreorder(root); // TC: O(n), SC: O(n)
    }
}
