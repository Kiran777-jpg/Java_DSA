package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class CheckIfSubsequenceExistForK {
    private static boolean recursion(int idx, int sum, int k, int[] nums) {
        if(sum==k) return true;
        if(idx==nums.length) return false;
        boolean ans = recursion(idx+1, sum+nums[idx], k, nums);
        if(ans==true)
            return true;
        return recursion(idx+1, sum, k, nums);
    }

    private static boolean checkSubsequenceSum(int[] nums, int k) {
        return recursion(0, 0, k, nums);
    }

    //method2
    private static boolean recursion2(int idx, int sum, int k, int[] nums, List<Integer> temp) {
        System.out.println(temp);
        if(sum==k) return true;
        boolean ans=false;
        for(int i=idx;i<nums.length;i++) {
            temp.add(nums[i]);
            ans = ans||recursion2(i + 1, sum + nums[i], k, nums, temp);
            if(ans)
                return true;
            temp.removeLast();
        }
        return false;
    }

    private static boolean checkSubsequenceSum2(int[] nums, int k) {
        return recursion2(0, 0, k, nums, new ArrayList<>());
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        int k = 8;
        int[] nums = {4, 3, 9, 2};
        int k = 10;
        System.out.println(checkSubsequenceSum(nums, k));
        System.out.println(checkSubsequenceSum2(nums, k));
    }
}
