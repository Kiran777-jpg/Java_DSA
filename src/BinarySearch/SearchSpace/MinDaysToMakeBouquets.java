package BinarySearch.SearchSpace;
import java.util.Arrays;

public class MinDaysToMakeBouquets {

    public static boolean isvalid(int[] arr, int m, int k, int days) {
        int bouquets=0, count=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=days)
                count++;
            else
                count=0;
            if(count==k) {
                bouquets++;
                count=0;
            }
        }
        return bouquets>=m;
    }

    public static int solve(int[] arr, int m, int k) {
        int n=arr.length;
        if(n<(m*k))
            return -1;
        int start=Arrays.stream(arr).min().getAsInt();
        int end=Arrays.stream(arr).max().getAsInt();
        int ans=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(isvalid(arr, m, k, mid)) {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2, k = 3;
//        int arr[] = {1, 10, 3, 10, 2};
//        int m = 3, k = 2;
        System.out.println(solve(arr, m, k));  //TC:  O(log(max(arr[]))*N), SC: O(1)
    }
}
