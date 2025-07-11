package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class CountAllSubsequencesK {

    private static int recursion(int sum, int idx, int k, int[] nums) {
        if(idx==nums.length) {
            if(sum==k)
                return 1;
            return 0;
        }
        int l=recursion(sum+nums[idx], idx+1, k, nums);
        int r=recursion(sum, idx+1, k, nums);
        return l+r;
    }

    private static int countSubsequenceWithTargetSum(int[] nums, int k) {
        int ans = recursion(0, 0, k, nums);
        return ans;
    }

    //method2
    private static int count=0;
    private static void recursion2(int sum, int idx, int k, int[] nums, List<Integer> temp) {
        if(sum==k)
            count++;
        for(int i=idx;i<nums.length;i++) {
            temp.add(nums[i]);
            recursion2(sum+nums[i], i+1, k, nums, temp);
            temp.removeLast();
        }
    }


    private static int countSubsequenceWithTargetSum2(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();
        recursion2(0, 0, k, nums, temp);
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 9, 2, 5, 1};
//        int k = 10;
        int[] nums = {4, 2, 10, 5, 1, 3};
        int k = 5;
        System.out.println(countSubsequenceWithTargetSum(nums, k));
        System.out.println(countSubsequenceWithTargetSum2(nums, k));
    }
}
