package binaryTrees.traversals;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class LevelorderTraversal {

    private static List<List<Integer>> levelorder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            while(size-- > 0) {
                Node node=q.remove();
                level.add(node.data);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = BinaryTreeCreation.buildTree2();
        System.out.println("in: " + root.data);
        List<List<Integer>> ans=levelorder(root);  // TC: O(n), SC: O(n) -> for each level we sre storing the nodes and for last level in worst case has n/2 nodes
        for(List<Integer> list : ans)
            System.out.println(list);
    }
}
