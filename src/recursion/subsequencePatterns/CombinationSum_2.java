package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_2 {

    private static void recursion(int idx, int target, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<nums.length;i++) {
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            temp.add(nums[i]);
            recursion(i+1,target-nums[i],nums,temp,ans);
            temp.removeLast();
        }
    }

    private static List<List<Integer>> combinataionSumUitl(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        recursion(0, target, nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2};
//        int target = 4;
//        int[] nums = {10,1,2,7,6,1,5};
//        int target = 8;
        int[] nums = {2,5,2,1,2};
        int target = 5;


        List<List<Integer>> ans=combinataionSumUitl(nums, target);  // TC: O(2^n)*O(K), SC: O(K)
                                                                    // TC: O(K) -> add temp list into ans
        for(List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
