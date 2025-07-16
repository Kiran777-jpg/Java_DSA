package binaryTrees.hardLevel;

import binaryTrees.traversals.creation.BinaryTreeCreation;
import binaryTrees.traversals.creation.Node;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeByPreIn {
    private static Node recursion(int[] preorder, int preStart, int preEnd, int[] inorder,
                                  int inStart, int inEnd, Map<Integer, Integer> hashmap) {
        if(preStart>preEnd || inStart>inEnd)
            return null;

        Node root=new Node(preorder[preStart]);

        int idx=hashmap.get(root.data);
        int numsLeft=idx-inStart;

        root.left=recursion(preorder,preStart+1,preStart+numsLeft, inorder,
                            inStart, idx-1, hashmap);
        root.right=recursion(preorder,preStart+numsLeft+1, preEnd,
                inorder, idx+1, inEnd, hashmap);
        return root;
    }

    private static void construct(int[] inorder, int[] preorder) {
        Map<Integer, Integer> hashmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hashmap.put(inorder[i], i);
        Node root=recursion(preorder,0, preorder.length-1, inorder,
                0, inorder.length-1, hashmap);

        //Testing
        System.out.println("inorder: ");
        BinaryTreeCreation.inorder(root);
        System.out.println("preorder: ");
        BinaryTreeCreation.preorder(root);
    }
    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[] preorder={3,9,20,15,7};
        construct(inorder, preorder); // TC: O(n), SC: O(n)
    }
}
