package binaryTrees.hardLevel;

import binaryTrees.hardLevel.models.Pair;
import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {

    private static int bfs(Node root) {
        int ans=0;
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size=q.size();
            int mini=q.peek().getSecond();
            int first_idx=0, last_idx=0;
            for(int i=0;i<size;i++) {
                Pair pair=q.remove();
                root=pair.getFirst();
                int curr=pair.getSecond()-mini;

                if(i==0) first_idx=curr;
                if(i==size-1) last_idx=curr;

                if(root.left!=null)
                    q.add(new Pair(root.left, 2*curr+1));
                if(root.right!=null)
                    q.add(new Pair(root.right, 2*curr+2));
            }
            ans=Math.max(ans, (last_idx-first_idx+1));
        }
        return ans;
    }

    private static void maxWidth(Node root) {
        int ans=bfs(root);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root= BinaryTreeCreation.buildTree2();
        maxWidth(root);  // TC: O(n), SC: O(n)
    }
}
