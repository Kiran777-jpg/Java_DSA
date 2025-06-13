package BinarySearch.SearchSpace;

import java.util.Arrays;

public class KokoEatingBananas {

    public static boolean isValid(int[] arr, int h, int cap) {
        int hours=0;
        for(int i=0;i<arr.length;i++)
            hours+=(int)Math.ceil((double)arr[i]/(double)cap);
        return hours<=h;
    }

    public static int solve(int[] arr, int h) {
        int start=Arrays.stream(arr).min().getAsInt();
        int end=Arrays.stream(arr).max().getAsInt();
        int ans=Integer.MAX_VALUE;

        while(start<=end) {
            int mid=start+(end-start)/2;
            if(isValid(arr, h, mid)) {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int arr[] = {7,15,6,3};
//        int h=8;
        int arr[] = {25, 12, 8, 14, 19};
        int h=5;
        System.out.println(solve(arr, h));  // TC: O(nlog(max(arr[]))), SC: O(1)
    }
}
