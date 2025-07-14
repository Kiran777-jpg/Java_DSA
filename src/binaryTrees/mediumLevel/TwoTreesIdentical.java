package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class TwoTreesIdentical {

    private static boolean isTreesIdentical(Node root1, Node root2) {
        if(root1==null || root2==null) return root1==root2;
        return root1.data == root2.data && isTreesIdentical(root1.left, root2.left)
                && isTreesIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        Node root2 = BinaryTreeCreation.buildTree2();
//        root2.left.left.right=new Node(7);
        System.out.println(isTreesIdentical(root, root2));

    }
}
