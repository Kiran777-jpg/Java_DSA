package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class SymmetricalTrees {

    private static boolean isTreesSymmetrical(Node root1, Node root2) {
        if(root1==null || root2==null) return root1==root2;
        return root1.data == root2.data && isTreesSymmetrical(root1.left, root2.right)
                && isTreesSymmetrical(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root = BinaryTreeCreation.buildTree2();
//        root2.left.left.right=new Node(7);
        System.out.println(isTreesSymmetrical(root.left, root.right)); // TC: O(n), SC:O(1)
    }

    /*
Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the traversal and the function compares the nodes in a symmetric manner.
Space Complexity: O(1) as no additional data structures or memory is allocated.
O(H): Recursive Stack Space is used to calculate the height of the tree at each node which is proportional to the height of the tree.
The recursive nature of the getHeight function, which incurs space on the call stack for each recursive call until it reaches the leaf nodes or the height of the tree.
     */
}
