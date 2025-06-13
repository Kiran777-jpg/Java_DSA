package BinarySearch.SearchSpace;
import java.util.Arrays;

public class AggressiveCows {

    public static boolean isValid(int[] arr, int cows, int distance) {
        int cowsAssign=1;
        int stall=arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i]-stall>=distance) {
                cowsAssign++;
                stall=arr[i];
            }
        }
        return cowsAssign>=cows;
    }

    public static int solve(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int start=1;
        int end=arr[n-1]-arr[0];
        int ans=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(isValid(arr, k, mid)) {
                ans=mid;
                start=mid+1;
            }
            else
                end=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int k = 4;
//        int arr[] = {0,3,4,7,10,9};
        int k = 2;
        int arr[] = {4,2,1,3,6};
        System.out.println(solve(arr, k));
    }
}
