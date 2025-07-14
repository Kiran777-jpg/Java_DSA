package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

public class MaxSumPathBinaryTree {
    private static int dfs(Node root, int[] ans) {
        if(root==null) return 0;
        int l=dfs(root.left, ans);
        int r=dfs(root.right, ans);
        int branchesSum=Math.max(l+r, Math.max(l ,r))+root.data;
        ans[0]=Math.max(ans[0], Math.max(branchesSum, root.data));
        return Math.max(Math.max(l, r)+root.data, root.data);
    }

    private static int findMaxPathSum(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);
        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root = BinaryTreeCreation.buildTree2();
        int ans[]={Integer.MIN_VALUE};
        System.out.println(dfs(root, ans));  // TC: O(n), SC: O(H) -> recursion stack space
        System.out.println("Max path sum: " + ans[0]);
        int maxi[]={Integer.MIN_VALUE};
        System.out.println(findMaxPathSum(root, maxi));
        System.out.println(maxi[0]);
    }
}
