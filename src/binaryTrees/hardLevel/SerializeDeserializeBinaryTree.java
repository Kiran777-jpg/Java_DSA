package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    private static String serialize(Node root) {
        if(root==null) return "";
        Queue<Node> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()) {
            root=q.remove();
            if(root==null)
                sb.append("#,");
            else {
                sb.append(root.data+",");
                q.add(root.left);
                q.add(root.right);
            }
        }
        return sb.toString();
    }

    private static Node deSerialize(String data) {
        if(data.isEmpty()) return null;
        StringBuilder s=new StringBuilder(data);

        int commaIdx=s.indexOf(",");
        String str=s.substring(0,commaIdx);
        s.delete(0, commaIdx+1);

        Node root=new Node(Integer.parseInt(str));
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node node=q.remove();

            commaIdx=s.indexOf(",");
            str=s.substring(0,commaIdx);
            s.delete(0,commaIdx+1);

            if(!str.equals("#")) {
                node.left=new Node(Integer.parseInt(str));
                q.add(node.left);
            }

            commaIdx=s.indexOf(",");
            str=s.substring(0,commaIdx);
            s.delete(0,commaIdx+1);

            if(!str.equals("#")) {
                node.right=new Node(Integer.parseInt(str));
                q.add(node.right);
            }
        }
        return root;
     }

     private static void serializeAndDeserialize(Node root) {
        String s=serialize(root);
         System.out.println(s);
        root=deSerialize(s);

        //Testing
         BinaryTreeCreation.inorder(root);
     }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree2();
        serializeAndDeserialize(root);
    }

    /*
Time Complexity: O(N)
serialize function: O(N), where N is the number of nodes in the tree. This is because the function performs a level-order traversal of the tree, visiting each node once.
deserialize function: O(N), where N is the number of nodes in the tree. Similar to the serialize function, it processes each node once while reconstructing the tree.
Space Complexity: O(N)
serialize function: O(N), where N is the maximum number of nodes at any level in the tree. In the worst case, the queue can hold all nodes at the last level of the tree.
deserialize function: O(N), where N is the maximum number of nodes at any level in the tree. The queue is used to store nodes during the reconstruction process, and in the worst case, it may hold all nodes at the last level.
    * */
}
