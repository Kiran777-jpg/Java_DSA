package DynamicProgramming.dpOnArraysIntro;

import java.util.Arrays;

public class FrogJump {

    private static int recursion2(int n, int[] heights, int[] dp) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= recursion2(n-1, heights,dp)+ Math.abs(heights[n]-heights[n-1]);
        if(n>1)
            jumpTwo = recursion2(n-2, heights,dp)+ Math.abs(heights[n]-heights[n-2]);

        return dp[n]=Math.min(jumpOne, jumpTwo);
    }

    private static int recursion(int n, int[] heights, int[] dp) {
        if(n==0) return 0;
        if(n==1) return Math.abs(heights[0]-heights[1]);
        if(dp[n]!=-1) return dp[n];
        return dp[n]=Math.min(recursion(n-1, heights, dp)+Math.abs(heights[n]-heights[n-1]),
                recursion(n-2, heights, dp)+Math.abs(heights[n]-heights[n-2]));
    }

    private static void memoization(int[] heights) {
        int n=heights.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        int ans=recursion(n-1, heights, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[] heights) {
        int n=heights.length;
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=Math.min(heights[0], heights[1]);
        for(int i=2;i<n;i++) {
            dp[i]=Math.min(dp[i-1]+Math.abs(heights[i]-heights[i-1]), dp[i-2]+Math.abs(heights[i]-heights[i-2]));
        }
        System.out.println(dp[n-1]);
    }

    private static void spaceOptimization(int[] heights) {
        int n=heights.length;
        int prev=Math.min(heights[0], heights[1]), prev2=0;
        for(int i=2;i<n;i++) {
            int curr=Math.min(prev+Math.abs(heights[i]-heights[i-1]), prev2+Math.abs(heights[i]-heights[i-2]));
            prev2=prev;
            prev=curr;
        }
        System.out.println(prev);
    }

    public static void main(String[] args) {
        int[] heights={10,20,30,10};
        memoization(heights);   // TC: O(n), SC: O(n)+O(n)
        tabulation(heights);    // TC: O(n), SC: O(n)
        spaceOptimization(heights);   // TC: O(n), SC: O(1)
    }
}
