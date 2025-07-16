package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class MinTimeToBurnBinaryTree {

    private static void makeParentConnection(Node root, Node parent, Map<Node, Node> parentHashmap)
    {
        if(root==null)
            return;
        if(parent!=null) parentHashmap.put(root, parent);
        makeParentConnection(root.left, root, parentHashmap);
        makeParentConnection(root.right, root, parentHashmap);
    }
    private static int bfs(Node root, Node target) {
        Map<Node, Node> parentHashmap = new HashMap<>();
        makeParentConnection(root, null, parentHashmap);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-- > 0)
            {
                Node node=q.poll();
                if(node.left!=null && !visited.containsKey(node.left))
                {
                    q.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right!=null && !visited.containsKey(node.right))
                {
                    q.offer(node.right);
                    visited.put(node.right, true);
                }
                if(parentHashmap.containsKey(node) && !visited.containsKey(parentHashmap.get(node)))
                {
                    q.offer(parentHashmap.get(node));
                    visited.put(parentHashmap.get(node), true);
                }
            }
            if(!q.isEmpty()) level++;
        }
        return level;
    }

    private static void burnTree(Node root) {
        int ans = bfs(root, root.left);
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree3();
        burnTree(root);
    }
}
