package binaryTrees.hardLevel;

import binaryTrees.hardLevel.models.Pair;
import binaryTrees.hardLevel.models.PairParent;
import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.*;

public class DistanceKNodesBinaryTree {

    private static void parentMapping(Node root, Node parent, Map<Node, Node> parentMap) {
        if(root==null) return;
        parentMap.put(root, parent);
        parentMapping(root.left, root, parentMap);
        parentMapping(root.right, root, parentMap);
    }

    private static List<Integer> bfs(Node root, Node target, int k) {
        List<Integer> ans=new ArrayList<>();
        Map<Node, Node> parentMap=new HashMap<>();
        parentMapping(root, null, parentMap);
        Queue<PairParent> q=new LinkedList<>();
        q.add(new PairParent(target,target, 0));
        while(!q.isEmpty()) {
            PairParent pair=q.remove();
            root=pair.getNode();
            Node parent=pair.getParent();
            int distance=pair.getDistance();
            if(distance==k)
                ans.add(root.data);
            if(distance>k)
                break;
            if(parentMap.get(root)!=null && parent!=parentMap.get(root)) {
                q.add(new PairParent(parentMap.get(root), root, distance+1));
            }
            if(root.left!=null && parent!=root.left) {
                q.add(new PairParent(root.left, root, distance+1));
            }
            if(root.right!=null && parent!=root.right) {
                q.add(new PairParent(root.right, root, distance+1));
            }
        }
        return ans;
    }

    private static void distanceKNodes(Node root) {
        int k=2;
//        int k=3;
//        List<Integer> ans = bfs(root, k);
        List<Integer> ans = bfs(root, root.left, k);
        System.out.println(ans);
    }

    private static void makeParentConnection(Node root, Node parent, Map<Node, Node> parentHashmap)
    {
        if(root==null)
            return;
        if(parent!=null) parentHashmap.put(root, parent);
        makeParentConnection(root.left, root, parentHashmap);
        makeParentConnection(root.right, root, parentHashmap);
    }
    private static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parentHashmap = new HashMap<>();
        makeParentConnection(root, null, parentHashmap);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        while(!q.isEmpty() && k-- > 0)
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
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll().data);
        }
        return ans;
    }

    private static void distanceKNodes2(Node root) {
        int k=2;
//        int k=3;
//        List<Integer> ans = bfs(root, k);
        List<Integer> ans = distanceK(root, root.left, k);
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree3();
        distanceKNodes(root);  // TC: O(n)+O(n), SC: O(n)+O(n)
        distanceKNodes2(root);  // TC: O(n)+O(n), SC: O(n)+O(n)+O(n)
    }
}
