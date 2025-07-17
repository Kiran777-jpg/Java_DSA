package DynamicProgramming.dpOnArraysIntro;

import java.util.Arrays;

public class MaxSumNonAdjacentEle {

    private static int recursion(int n, int[] arr, int[] dp) {
        if(n==0) return arr[0];
        if(n==1) return Math.max(arr[0], arr[1]);
        if(dp[n]!=-1) return dp[n];
        return dp[n]=Math.max(recursion(n-1, arr, dp), recursion(n-2, arr, dp)+arr[n]);
    }
    private static void memoization(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        int ans=recursion(arr.length-1, arr, dp);
        System.out.println(ans);
    }
    private static void tabulation(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0], arr[1]);
        for(int i=2;i<n;i++)
            dp[i]=Math.max(dp[i-2]+arr[i], dp[i-1]);
        System.out.println(dp[n-1]);
    }

    private static void tabulation2(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++) {
            int pick=arr[i];
            if(i>1)
                pick+=dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick, notPick);
        }
        System.out.println(dp[n-1]);
    }

    private static void spaceOptimization(int[] arr) {
        int n=arr.length;
        int prev=Math.max(arr[0], arr[1]), prev2=arr[0];
        for(int i=2;i<n;i++) {
            int curr=Math.max(prev2+arr[i], prev);
            prev2=prev;
            prev=curr;
        }
        System.out.println(prev);
    }

    public static void main(String[] args) {
        int[] arr={2,1,4,9};
        memoization(arr);  // TC: O(n), SC: O(n)+O(n)
        tabulation(arr);   // TC: O(n), SC: O(n)
        tabulation2(arr);   // TC: O(n), SC: O(n)
        spaceOptimization(arr);  // TC: O(n), SC: O(1)
    }
}
