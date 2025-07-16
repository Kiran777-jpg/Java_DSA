package binaryTrees.traversals;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class PostorderTraversal {

    private static void postorder(Node root) {
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + ", ");
    }

    private static void iterativePostorderChangingTree(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.peek();
            if(node.left!=null) {
                st.push(node.left);
                node.left=null;
            }
            else if(node.right!=null) {
                st.push(node.right);
                node.right=null;
            }
            else {
                postorder.add(node.data);
                st.pop();
            }
        }
        System.out.println(postorder);
    }

    private static void iterativePostorderHashMap(Node root) {
        Stack<Node> st=new Stack<>();
        Map<Node, Integer> hashmap=new HashMap<>();
        List<Integer> postorder=new ArrayList<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()) {
            Node node=st.peek();
            if(node.left!=null && !hashmap.containsKey(node)) {
                st.push(node.left);
                hashmap.put(node, 1);
            }
            else if(node.right!=null && hashmap.get(node)!=2){
                st.push(node.right);
                hashmap.put(node, 2);
            }
            else {
                postorder.add(node.data);
                st.pop();
            }
        }
        System.out.println(postorder);
    }

    private static void iterativePostorderTwoStacks(Node root) {
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            root=st1.pop();
            if(root.left!=null)
                st1.push(root.left);
            if(root.right!=null)
                st1.push(root.right);
            st2.push(root);
        }
        while(!st2.isEmpty()) {
            root=st2.pop();
            postorder.add(root.data);
        }
        System.out.println(postorder);
    }

    private static void iterativePostorderUsingSorting(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()) {
            root=st.pop();
            postorder.add(root.data);
            if(root.left!=null)
                st.push(root.left);
            if(root.right!=null)
                st.push(root.right);
        }
        Collections.reverse(postorder);
        System.out.println(postorder);
    }

    // PENDING NEED TO IMPLEMENT THIS APPROACH
    private static void iterativePostorderOptimized(Node root) {
        // PENDING NEED TO IMPLEMENT THIS APPROACH
        Stack<Node> st=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        while(!st.isEmpty() || root!=null) {
            if(root!=null) {
                st.push(root);
                root=root.left;
            }
            else {
                if(root.right!=null) {
                    st.push(root);
                    root=root.right;
                }
                else {
                    Node node=st.pop();
                    postorder.add(node.data);
                    root=st.peek();
                }
            }
        }
    }

    public static void main(String[] args) {
//        Node root = BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        postorder(root); // TC: O(3*n), SC: O(N)
        System.out.println();
        System.out.println("Iterative postorder changing the tree structure");
        Node root2 = BinaryTreeCreation.buildTree2();
        iterativePostorderChangingTree(root2);  // TC: O(n), SC:O(H)
        System.out.println("Iterative postorder using map without changing the tree structure");
        iterativePostorderHashMap(root);  // TC: O(n), SC:O(H)+O(n)
        System.out.println("Iterative postorder using two stacks");
        iterativePostorderTwoStacks(root);  // TC: O(n), SC:O(H)+O(n)
        System.out.println("Iterative postorder using sorting with one stack");
        iterativePostorderUsingSorting(root);
    }
}
