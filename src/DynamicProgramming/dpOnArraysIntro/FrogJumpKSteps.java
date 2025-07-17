package DynamicProgramming.dpOnArraysIntro;

import java.util.Arrays;

public class FrogJumpKSteps {

    private static int recursion(int n, int k, int[] heights, int[] dp) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++) {
            if(n-j>=0)
                ans=Math.min(ans, recursion(n-j, k, heights, dp)+Math.abs(heights[n]-heights[n-j]));
        }
        return ans;
    }

    private static void memoization(int[] heights, int k) {
        int n=heights.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        int ans=recursion(n-1, k, heights, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[] heights, int k) {
        int n=heights.length;
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=2;i<n;i++) {
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++) {
                if(i-j>=0) {
                    dp[i]=Math.min(dp[i], dp[i-j]+Math.abs(heights[i]-heights[i-j]));
                }
            }
        }
        System.out.println(dp[n-1]);
    }

    public static void main(String[] args) {
        int heights[] = { 30, 10, 60, 10, 60, 50 };
        int k = 2;
        memoization(heights,k);   // TC: O(n*k), SC: O(n)+O(n)
        tabulation(heights, k);    // TC: O(n*k), SC: O(n)
    }
}
