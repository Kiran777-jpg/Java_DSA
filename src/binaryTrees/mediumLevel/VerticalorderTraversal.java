package binaryTrees.mediumLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;
import com.sun.source.tree.Tree;

import java.util.*;

class Pair {
    Node first;
    int second;
    public Pair(Node first, int second) {
        this.first=first;
        this.second=second;
    }

    public Node getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
};

class Pair2 {
    Node first;
    int x;
    int y;
    public Pair2(Node first, int x, int y) {
        this.first=first;
        this.x=x;
        this.y=y;
    }

    public Node getFirst() {
        return first;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
};


public class VerticalorderTraversal {

    private static void verticalorderTraversal(Node root) {
        Map<Integer, List<Integer>> hashmap= new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair pair=q.remove();
            root=pair.getFirst();
            int val=pair.getSecond();
            if(!hashmap.containsKey(val)) {
                hashmap.put(val, new ArrayList<>(Arrays.asList(root.data)));
            }
            else {
                hashmap.get(val).add(root.data);
            }
            if(root.left!=null) {
                q.add(new Pair(root.left, val-1));
            }
            if(root.right!=null)
                q.add(new Pair(root.right, val+1));
        }

        for (Map.Entry<Integer, List<Integer>> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void verticalorderTraversalXY(Node root) {
        Map<Integer, Map<Integer, TreeSet<Integer>>> hashmap= new TreeMap<>();
        Queue<Pair2> q=new LinkedList<>();
        q.add(new Pair2(root, 0, 0));
        while(!q.isEmpty()) {
            Pair2 pair=q.remove();
            root=pair.getFirst();
            int x=pair.getX();
            int y=pair.getY();
//            hashmap.putIfAbsent(x, new TreeMap<>());
//            hashmap.get(x).putIfAbsent(y, new TreeSet<>());
            if(!hashmap.containsKey(x)) {
                hashmap.put(x, new TreeMap<>());
            }
            if(!hashmap.get(x).containsKey(y)) {
                hashmap.get(x).put(y, new TreeSet<>());
            }
            hashmap.get(x).get(y).add(root.data);
            if(root.left!=null) {
                q.add(new Pair2(root.left, x-1, y+1));
            }
            if(root.right!=null)
                q.add(new Pair2(root.right, x+1, y+1));
        }

        for (Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> entry : hashmap.entrySet()) {
            System.out.println("x: " + entry.getKey());
            Map<Integer, TreeSet<Integer>> innerHashmap=entry.getValue();
            for(Map.Entry<Integer, TreeSet<Integer>> entry2 : innerHashmap.entrySet()) {
                System.out.println("y: " + entry2.getKey() + ", " + entry2.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Node root= BinaryTreeCreation.buildTree2();
        verticalorderTraversal(root);
        verticalorderTraversalXY(root);

        /*
Time Complexity: O(N * log2N * log2N * log2N) where N represents the number of nodes in the Binary Tree.
Postorder Traversal performed using BFS as a time complexity of O(N) as we are visiting each and every node once.
Multiset Operations to insert overlapping nodes at a specific vertical and horizontal level also takes O(log2N) complexity.
Map operations involve insertion and retrieval of nodes with their vertical and level as their keys. Since there are two nested maps, the total time complexity becomes O(log2N)*O(log2N).

Space Complexity: O(N + N/2) where N represents the number of nodes in the Binary Tree.
The map for storing nodes based on their vertical and level information occupies an additional space complexity of O(N) as it stores all N nodes of the Binary Tree.
The queue for breadth first traversal occupies a space proportional to the maximum level of the tree which can be O(N/2) in the worst case of a balanced tree.
         */
    }
}
