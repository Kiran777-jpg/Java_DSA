package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    private static void flattenUSingStack(Node root) {
        Stack<Node> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.pop();
            if(node.right!=null)
                st.push(node.right);
            if(node.left!=null)
                st.push(node.left);
            if(!st.isEmpty())
                node.right=st.peek();
            node.left=null;
        }

        while(root!=null) {
            System.out.print(root.data+", ");
            root=root.right;
        }
        System.out.println();
    }

    private static void flattenIteration(Node root) {
        Node node=root;
        while(node!=null) {
            if(node.left!=null) {
                Node prev=node.left;
                while(prev.right!=null)
                    prev=prev.right;
                prev.right=node.right;
                node.right=node.left;
            }
            node=node.right;
        }

        while(root!=null) {
            System.out.print(root.data+", ");
            root=root.right;
        }
        System.out.println();
    }

    private static Node prev=null;
    private static void recursion(Node root) {
        if(root==null) return;
        recursion(root.right);
        recursion(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }

    private static void recursionUtil(Node root) {
        recursion(root);
        while(root!=null) {
            System.out.print(root.data+", ");
            root=root.right;
        }
        System.out.println();
    }


    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree2();
        recursionUtil(root);   // TC: O(n), SC: O(H)
        root= BinaryTreeCreation.buildTree2();
        flattenUSingStack(root);   // TC: O(n), SC: O(H)
        root= BinaryTreeCreation.buildTree2();
        flattenIteration(root);  // TC: O(n), SC: O(1)
    }
}
