package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    private static void morrisInorderTraversal(Node root) {
        List<Integer> ans=new ArrayList<>();
        while(root!=null) {
            if(root.left!=null) {
                Node temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==root) {
                    temp.right=null;
                    ans.add(root.data);
                    root=root.right;
                }
                else {
                    temp.right=root;
                    root=root.left;
                }
            }
            else {
                ans.add(root.data);
                root=root.right;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree2();
        morrisInorderTraversal(root);
    }

    /*
Time Complexity: O(2N) where N is the number of nodes in the Binary Tree.
The time complexity is linear, as each node is visited at most twice (once for establishing the temporary link and once for reverting it).
In each step, we perform constant-time operations, such as moving to the left or right child and updating pointers.
Space Complexity: O(1) The space complexity is constant, as the algorithm uses only a constant amount of extra space irrespective of the input size.
Morris Traversal does not use any additional data structures like stacks or recursion, making it an in-place algorithm.
The only space utilised is for a few auxiliary variables, such as pointers to current and in-order predecessor nodes.*/
}
