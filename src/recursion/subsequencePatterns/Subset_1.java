package recursion.subsequencePatterns;

import java.util.*;
import java.util.stream.Collectors;

public class Subset_1 {

    private static void recursion(int idx, int sum, int[] nums, List<Integer> ans) {
        if(idx==nums.length) {
            ans.add(sum);
            return;
        }
        recursion(idx+1, sum, nums, ans);
        recursion(idx+1, sum+nums[idx], nums, ans);
    }

    private static void subset1(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        recursion(0, 0, nums, ans);
        Collections.sort(ans);
        for(int x : ans)
            System.out.print(x + ", ");
        System.out.println();
    }

    private static void subset2(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        nums=Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        recursion(0, 0, nums, ans);
        for(int x : ans)
            System.out.print(x + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] nums = {2,1,3};
        int[] nums = {5,2,1};
        subset1(nums);  // TC: O(2^n)*O(2^nlog(2^n)), SC:O(2^n)
        subset2(nums);  // TC: O(2^n)*O(nlogn), SC:O(2^n)
    }
}
