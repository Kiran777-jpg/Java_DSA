package DynamicProgramming.dpOnArraysIntro;

import java.util.Arrays;

public class FibonacciNumber {

    private static int fibRecursion(int n) {
//        if(n==0 || n==1) return n;
        if(n<=1) return n;
        return fibRecursion(n-1)+fibRecursion(n-2);
    }

    private static int fibMemo(int n, int[] dp) {
//        if(n==0 || n==1) return n;
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibMemo(n-1, dp)+fibMemo(n-2, dp);
    }

    private static void fibMemoization(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        int ans=fibMemo(n, dp);
        System.out.println(ans);
    }

    private static void fibTabulation(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        System.out.println(dp[n]);
    }

    private static void fibVariables(int n) {
        int prev1=1, prev2=0;
        int curr=0;
        for(int i=2;i<=n;i++) {
            curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        System.out.println(curr);
    }

    public static void main(String[] args) {
        int n=4;
        fibRecursion(n);  // TC: O(2^n), SC: O(n)
        fibMemoization(n); // TC: O(n), SC: O(n)+O(n)
        fibTabulation(n);  // TC: O(n), SC: O(n)
        fibVariables(n);  // TC: O(n), SC: O(1)
    }
}
