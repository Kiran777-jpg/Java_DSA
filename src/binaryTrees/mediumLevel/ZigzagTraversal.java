package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class ZigzagTraversal {

    private static void levelorderTraversal(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null) return;
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()) {
            int size= q.size();
            List<Integer> temp=new ArrayList<>(size);
            while((size--)>0) {
                root=q.remove();
                if(flag)
                    temp.add(root.data);
                else
                    temp.add(0, root.data);
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);
            }
            flag=!flag;
            ans.add(temp);
        }
        for(List<Integer> list : ans)
            System.out.println(list);
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree2();
        levelorderTraversal(root);
    }
}
