package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

    private static int recursion(Node root) {
        if (root == null) return 0;
        int l = recursion(root.left);
        int r = recursion(root.right);
        return Math.max(l, r) + 1;
    }

    private static int levelorderTraverasl(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.poll();
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root = BinaryTreeCreation.buildTree2();
        System.out.println(recursion(root));  // TC: O(n), SC: O(H) -> recursion stack space
        System.out.println(levelorderTraverasl(root)); // TC: O(n), SC:O(n) -> balanced tree n/2 nodes in last level
    }
}
