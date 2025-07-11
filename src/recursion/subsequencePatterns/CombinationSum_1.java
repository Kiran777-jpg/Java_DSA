package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_1 {

    private static void recursion(int sum, int idx, int target, int nums[], List<Integer> temp, List<List<Integer>> ans) {
        if(idx==nums.length) {
            if(sum==target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(sum+nums[idx]<=target) {
            temp.add(nums[idx]);
            recursion(sum+nums[idx], idx, target, nums, temp, ans);
            temp.removeLast();
        }
        recursion(sum, idx+1, target, nums, temp, ans);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0, 0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    //method2
    private static void recursion2(int idx, int target, int nums[], List<Integer> temp, List<List<Integer>> ans) {
        if(idx==nums.length) {
            if(target==0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[idx]<=target) {
            temp.add(nums[idx]);
            recursion2(idx, target-nums[idx], nums, temp, ans);
            temp.removeLast();
        }
        recursion2(idx+1, target, nums, temp, ans);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion2(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    //method3
    private static void recursion3(int idx, int target, int nums[], List<Integer> temp, List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(temp));
//            return;
        }
        for(int i=idx;i<nums.length;i++) {
            if(nums[i]<=target) {
                temp.add(nums[i]);
                recursion3(idx, target-nums[i], nums, temp, ans);
                temp.removeLast();
            }
        }
    }

    private static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion2(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4};
        int target = 7;
        List<List<Integer>> ans=combinationSum(nums, target);
        for(List<Integer> list : ans)
            System.out.println(list);

        System.out.println("method2");
        ans=combinationSum2(nums, target);
        for(List<Integer> list : ans)
            System.out.println(list);

        System.out.println("method3");
        ans=combinationSum3(nums, target);
        for(List<Integer> list : ans)
            System.out.println(list);
    }
}
