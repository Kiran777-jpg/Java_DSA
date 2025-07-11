package recursion.subsequencePatterns;

import java.util.*;

public class Subset_2 {

    private static void recursion(int idx, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++) {
            if(i>idx && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            recursion(i+1, nums, temp, ans);
            temp.removeLast();
        }
    }

    private static void subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        recursion(0, nums, new ArrayList<>(), ans);
        for(List<Integer> list : ans)
            System.out.println(list);
        System.out.println();
    }

    private static void recursion1(int idx, int[] nums, List<Integer> temp, HashSet<String> hashset) {
        if(idx==nums.length) {
            Collections.sort(temp);
            hashset.add(temp.toString());
            return;
        }
        temp.add(nums[idx]);
        recursion1(idx+1, nums, temp, hashset);
        temp.removeLast();
        recursion1(idx+1, nums, temp, hashset);
    }

    private static void subsetWithHash(int[] nums) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hashset = new HashSet<>();
        recursion1(0, nums, new ArrayList<>(), hashset);
        for(String s : hashset)
            ans.add(s);
        for(String list : ans)
            System.out.println(list);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetWithHash(nums);
        subset(nums);

        // subsetWithHash Time and space complexity
        /*
        Time Complexity: O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log( x)  to insert every combination of average length k in a set of size x. After this, we have to convert the set of combinations back into a list of list /vector of vectors which takes more time.
        Space Complexity:  O(2^n * k) to store every subset of average length k. Since we are initially using a set to store the answer another O(2^n *k) is also used.
        */


        // subset Time and space complexity
        /*
        Time Complexity: O(2^n) for generating every subset and O(k)  to insert every subset in another data structure if the average length of every subset is k. Overall O(k * 2^n).
        Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.
        */
    }
}
