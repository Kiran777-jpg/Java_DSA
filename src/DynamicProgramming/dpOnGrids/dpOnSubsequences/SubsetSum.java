package DynamicProgramming.dpOnGrids.dpOnSubsequences;

import java.util.Arrays;

public class SubsetSum {

    private static boolean dfs(int i, int j, int[] arr, int[][] dp) {
        if(j==0) return true;
        if(i==0) return arr[i]==j;

        if(dp[i][j]!=-1) return dp[i][j]==1;

        boolean notTaken = dfs(i-1, j, arr, dp);
        boolean taken = false;
        if(arr[i]<=j)
            taken = dfs(i-1, j-arr[i], arr, dp);
        dp[i][j] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }

    private static void memoization(int[] arr, int tar) {
        int[][] dp=new int[arr.length][tar+1];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(dp[i], -1);
        boolean ans = dfs(arr.length-1, tar, arr, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[] arr, int tar) {
        boolean[][] dp=new boolean[arr.length][tar+1];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<=tar;j++) {
                if(j==0) dp[i][j]=true;
                if(i==0) dp[i][j]=(arr[i]==j);
                else {
                    boolean notTaken = dp[i-1][j];
                    boolean taken = false;
                    if(arr[i]<=j)
                        taken = dp[i-1][j-arr[i]];
                    dp[i][j] = notTaken || taken;
                }
            }
        }
        System.out.println(dp[arr.length-1][tar]);
    }

    private static void spaceOptimization(int[] arr, int tar) {
        boolean[] prev=new boolean[tar+1];
        boolean[] curr=new boolean[tar+1];

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<=tar;j++) {
                if(j==0) curr[j]=true;
                if(i==0) curr[j]=(arr[i]==j);
                else {
                    boolean notTaken = prev[j];
                    boolean taken = false;
                    if(arr[i]<=j)
                        taken = prev[j-arr[i]];
                    curr[j] = notTaken || taken;
                }
            }
            prev=curr;
        }
        System.out.println(prev[tar]);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int tar=4;
        memoization(arr, tar);
        tabulation(arr, tar);
        spaceOptimization(arr, tar);
    }
}
