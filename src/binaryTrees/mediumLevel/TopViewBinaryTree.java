package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {

    private static void topViewBfs(Node root) {
        Map<Integer, Integer> hashmap=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair pair=q.remove();
            root=pair.getFirst();
            int x=pair.getSecond();
            if(!hashmap.containsKey(x))
                hashmap.put(x, root.data);
            if(root.left!=null)
                q.add(new Pair(root.left, x-1));
            if(root.right!=null)
                q.add(new Pair(root.right, x+1));
        }

        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree();
//        Node root=BinaryTreeCreation.buildTree2();
        topViewBfs(root); // TC: O(n)+o(nlogn), SC: O(n)+O(n)
    }
}
