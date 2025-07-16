package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    private static boolean dfs(Node root, Node node, List<Integer> path) {
        if(root==null) return false;
        path.add(root.data);
        if(root==node) return true;
        if(dfs(root.left, node, path) || dfs(root.right, node, path))
            return true;
        path.removeLast();
        return false;
    }

    private static void rootToNodePath(Node root, Node node) {
        List<Integer> path=new ArrayList<>();
        boolean isPath=dfs(root, node, path);
        System.out.println(isPath + ", " + path);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
//        rootToNodePath(root, root.left.right);
        rootToNodePath(root, root.left.right.left);  // TC: O(n), SC: O(H)
    }

    /*
Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once in the inorder traversal.
Space Complexity: O(N) awhere N is the number of nodes in the binary tree. This is because the stack can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), consuming space proportional to the number of nodes.
O(H): In the average case or for a balanced tree, the maximum number of nodes that could be in the stack at any given time would be roughly the height of the tree hence O(log2N).
     */

}
