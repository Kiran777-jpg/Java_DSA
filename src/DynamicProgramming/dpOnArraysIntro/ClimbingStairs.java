package DynamicProgramming.dpOnArraysIntro;

import java.util.Arrays;

public class ClimbingStairs {

    private static int recursion(int n, int[] dp) {
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=recursion(n-1,dp)+recursion(n-2, dp);
    }

    private static void memoization(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        int ans=recursion(n, dp);
        System.out.println(ans);
    }

    private static void tabulation(int n) {
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        System.out.println(dp[n]);
    }

    private static void spaceOptimization(int n) {
        int prev=1, prev2=1;
        for(int i=2;i<=n;i++) {
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        System.out.println(prev);
    }

    public static void main(String[] args) {
        int n=3;
        memoization(n);  // TC: O(n), SC: O(n)+O(n)
        tabulation(n);   // TC: O(n), SC: O(n)
        spaceOptimization(n);   // TC: O(n), SC: O(1)
    }
}
