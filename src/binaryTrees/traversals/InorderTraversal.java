package binaryTrees.traversals;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class InorderTraversal {

    private static void inorder(Node root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }

    private static void iterativeInorderChangingTree(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> inorder=new ArrayList<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.peek();
            if(node.left!=null) {
                st.push(node.left);
                node.left=null;
            }
            else {
                inorder.add(node.data);
                st.pop();
                if(node.right!=null)
                    st.push(node.right);

            }
        }
        System.out.println(inorder);
    }

    private static void iterativeInorderHashMap(Node root) {
        Stack<Node> st=new Stack<>();
        Map<Node, Boolean> hashmap=new HashMap<>();
        List<Integer> inorder=new ArrayList<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.peek();
            if(node.left!=null && !hashmap.containsKey(node)) {
                st.push(node.left);
                hashmap.put(node, true);
            }
            else {
                inorder.add(node.data);
                st.pop();
                if(node.right!=null)
                    st.push(node.right);
            }
        }
        System.out.println(inorder);
    }

    private static void iterativeInorder(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> inorder=new ArrayList<>();
        if(root==null) return;
        while(!st.isEmpty() || root!=null) {
            if(root!=null) {
                st.push(root);
                root=root.left;
            }
            else {
                Node node=st.pop();
                inorder.add(node.data);
                root=node.right;
            }
        }
        System.out.println(inorder);
    }

    public static void main(String[] args) {
        Node root = BinaryTreeCreation.buildTree2();
        inorder(root); // TC: O(3*n), SC: O(N)
        System.out.println("Iterative inorder changing the tree structure");
        Node root2 = BinaryTreeCreation.buildTree2();
        iterativeInorderChangingTree(root2);  // TC: O(n), SC:O(H)
        System.out.println("Iterative inorder using map without changing the tree structure");
        iterativeInorderHashMap(root);  // TC: O(n), SC:O(H)+O(n)
        System.out.println("Iterative inorder optimized");
        iterativeInorder(root); // TC: O(n), SC:O(H)
    }

/*
    solution Approach:

    Think stack.

    Recursive call would look something like this :

    inorderprint(root->left);
    print(root->val);
    inorderprint(root->right);

    Instead of calling the functions, can you put the nodes on a stack and process them?

    How would your solution work if you could change the original tree?
    How would it work if you were not allowed to change the tree but use additional memory ( track the number of times a node has appeared in the tree )?
    How would it work if you were not even allowed the extra memory?
    */
}
