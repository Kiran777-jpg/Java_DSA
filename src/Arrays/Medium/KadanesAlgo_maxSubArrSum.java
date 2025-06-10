package Arrays.Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class KadanesAlgo_maxSubArrSum {

    public static long maxSubarraySum(int[] arr) {
        int n=arr.length;
        long sum=0, maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++) {
            sum+=arr[i];
            if(sum<0)
                sum=0;
            maxi=Math.max(maxi, sum);
        }
        return maxi;
    }

    public static ArrayList<Integer> printMaxSumSubarray(int[] arr) {
        int n=arr.length;
        long sum=0, maxi=Long.MIN_VALUE;
        int start_idx=-1, end_idx=-1, count=0;
        for(int i=0;i<n;i++) {
            sum+=arr[i];
            count++;
            if(sum<0) {
                sum=0;
                count=0;
            }
            if(sum>maxi) {
                start_idx=i-count+1;
                end_idx=i;
                maxi=sum;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=start_idx;i<=end_idx;i++)
            ans.add(arr[i]);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        long maxSum = maxSubarraySum(arr);
        System.out.println(maxSum);
        ArrayList<Integer> ans = printMaxSumSubarray(arr);
        ans.forEach(x -> System.out.print(x + ", "));
    }
}
