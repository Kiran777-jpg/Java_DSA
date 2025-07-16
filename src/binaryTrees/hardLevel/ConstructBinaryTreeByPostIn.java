package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeByPostIn {
    private static Node recursion(int[] postorder, int posStart, int posEnd, int[] inorder,
                                  int inStart, int inEnd, Map<Integer, Integer> hashmap) {
        if(posStart>posEnd || inStart>inEnd)
            return null;
        Node root=new Node(postorder[posEnd]);

        int idx=hashmap.get(root.data);
        int numsRight=inEnd-idx;

        root.left=recursion(postorder, posStart, posEnd-numsRight-1, inorder,
                inStart, idx-1, hashmap);
        root.right=recursion(postorder, posEnd-numsRight, posEnd-1, inorder,
                idx+1, inEnd, hashmap);
        return root;
    }

    private static void construct(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hashmap.put(inorder[i], i);
        Node root=recursion(postorder,0, postorder.length-1, inorder,
                0, inorder.length-1, hashmap);

        //Testing
        System.out.println("inorder: ");
        BinaryTreeCreation.inorder(root);
        System.out.println("postorder: ");
        BinaryTreeCreation.postorder(root);
    }

    private static Node recursion2(int[] inorder, int is, int ie,
                                    int[] postorder, int ps, int pe, Map<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }

        Node root = new Node(postorder[pe]);

        int inRoot = hm.get(root.data);
        int numsLeft = inRoot - is;

        root.left = recursion2(inorder, is, inRoot - 1, postorder,
                ps, ps + numsLeft - 1, hm);

        root.right = recursion2(inorder, inRoot + 1, ie, postorder,
                ps + numsLeft, pe - 1, hm);

        return root;
    }

    private static void construct2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hashmap.put(inorder[i], i);
        Node root=recursion2(inorder,0, inorder.length-1, postorder,0,
                postorder.length-1,  hashmap);
        //Testing
        System.out.println("inorder: ");
        BinaryTreeCreation.inorder(root);
        System.out.println("postorder: ");
        BinaryTreeCreation.postorder(root);
    }

    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[] postorder={9,15,7,20,3};
        construct(inorder, postorder); // TC: O(n), SC: O(n)
        construct2(inorder, postorder); // TC: O(n), SC: O(n)
    }
}
