package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class LowestCommonAncestor {

    private static Node dfs(Node root, Node node1, Node node2) {
        if(root==null) return null;
        if(root==node1 || root==node2) return root;
        Node l=dfs(root.left, node1, node2);
        Node r=dfs(root.right, node1, node2);
        if(l==null) return r;
        if(r==null) return l;
        return root;
    }

    private static void lca(Node root, Node node1, Node node2) {
        Node ans=dfs(root, node1, node2);
        System.out.println(ans.data);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
//        lca(root, root.left.left.left, root.left.right);
        lca(root, root.left.right.left.left, root.left.right.right);
    }

    // Time complexity: O(N) where n is the number of nodes.
    //Space complexity: O(N), auxiliary space.
}
