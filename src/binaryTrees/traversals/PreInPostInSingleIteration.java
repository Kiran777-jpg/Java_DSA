package binaryTrees.traversals;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    private Node first;
    private int second;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    Pair(Node first, int second) {
        this.first=first;
        this.second=second;
    }
}

public class PreInPostInSingleIteration {

    private static void traversals(Node root) {
        List<Integer> preorder=new ArrayList<>();
        List<Integer> inorder=new ArrayList<>();
        List<Integer> postorder=new ArrayList<>();
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()) {
            Pair pair=st.pop();
            root=pair.getFirst();
            int val=pair.getSecond();
            if(val==1) {
                preorder.add(root.data);
                pair.setSecond(2);
                st.push(pair);
                if(root.left!=null)
                    st.push(new Pair(root.left, 1));
            }
            else if(val==2) {
                inorder.add(root.data);
                pair.setSecond(3);
                st.push(pair);
                if(root.right!=null)
                    st.push(new Pair(root.right, 1));
            }
            else
                postorder.add(root.data);
        }
        System.out.println("preorder: " + preorder);
        System.out.println("inorder: " + inorder);
        System.out.println("postorder: " + postorder);
    }

    public static void main(String[] args) {
//        Node root= BinaryTreeCreation.buildTree();
        Node root= BinaryTreeCreation.buildTree2();
        traversals(root);
    }
}
