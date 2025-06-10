package Arrays.Medium;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int x=target-arr[i];
            if(hashmap.containsKey(x))
                return new int[]{hashmap.get(x), i};
            hashmap.put(arr[i], i);
        }
        return new int[2];
    }

    public static int[] twoSumUsingTwoPointers(int[] arr, int target) {
       Arrays.sort(arr);
       int left=0, right=arr.length-1;
       while(left<right) {
           int sum=arr[left]+arr[right];
           System.out.println(sum + ", " + left + ", " + right);
           if(sum==target)
               return new int[]{arr[left], arr[right]};

           if(sum<target)
               left++;
           else
               right--;
       }
       return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(arr, target);
        System.out.println(ans[0] + ", " + ans[1]);  // TC: O(n), SC: O(n)
        ans = twoSumUsingTwoPointers(arr, target);   // TC: O(nlogn)+O(n), SC:O(n)
        System.out.println(ans[0] + ", " + ans[1]);
    }
}
