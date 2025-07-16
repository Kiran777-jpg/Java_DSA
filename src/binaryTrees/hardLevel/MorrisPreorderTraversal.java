package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {

    private static void morrisPreorderTraversal(Node root) {
        List<Integer> inorder=new ArrayList<>();
        List<Integer> preorder=new ArrayList<>();
        while(root!=null) {
            if(root.left!=null) {
                Node temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==root) {
                    temp.right=null;
                    inorder.add(root.data);
                    root=root.right;
                }
                else {
                    preorder.add(root.data);
                    temp.right=root;
                    root=root.left;
                }
            }
            else {
                inorder.add(root.data);
                preorder.add(root.data);
                root=root.right;
            }
        }
        System.out.println("preorder: " + preorder);
        System.out.println("inorder: " + inorder);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
        morrisPreorderTraversal(root);
    }

    /*
Time Complexity: O(2N) where N is the number of nodes in the Binary Tree.
The time complexity is linear, as each node is visited at most twice (once for establishing the temporary link and once for reverting it).
In each step, we perform constant-time operations, such as moving to the left or right child and updating pointers.
Space Complexity: O(1) The space complexity is constant, as the algorithm uses only a constant amount of extra space irrespective of the input size.
Morris Traversal does not use any additional data structures like stacks or recursion, making it an in-place algorithm.
The only space utilised is for a few auxiliary variables, such as pointers to current and in-order predecessor nodes.*/
}
