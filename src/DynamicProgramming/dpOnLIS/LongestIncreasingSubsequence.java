package DynamicProgramming.dpOnLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int recursion(int i, int j, int[] arr, int[][] dp) {
        if(i==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int notTaken = recursion(i-1, j, arr, dp);
        int taken = 0;
        if(j==arr.length || arr[j] > arr[i-1])
            taken = recursion(i-1, i-1, arr, dp) + 1;
        return dp[i][j]=Math.max(notTaken, taken);
    }

    private static void memoization(int[] arr) {
        int n=arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        int ans = recursion(n, n, arr, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[] arr) {
        int n=arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                int notTaken = dp[i-1][j];
                int taken=0;
                if(j==arr.length || arr[j] > arr[i-1])
                    taken=dp[i-1][i-1]+1;
                dp[i][j] = Math.max(notTaken, taken);
            }
        }
        System.out.println(dp[n][n]);
        for(int x : dp[n])
            System.out.print(x+" ");
        System.out.println();

    }

    private static void spaceOptimization(int[] arr) {
        int n=arr.length;
        int[] prev = new int[n+1];
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                int notTaken = prev[j];
                int taken=0;
                if(j==arr.length || arr[j] > arr[i-1])
                    taken=prev[i-1]+1;
                prev[j] = Math.max(notTaken, taken);
            }
        }
        System.out.println(prev[n]);
        for(int x : prev)
            System.out.print(x+" ");
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] arr = {9,2,5,3,6};
        int[] arr = {10,9,2,5,3,7,101,18};
        memoization(arr);
        tabulation(arr);
        spaceOptimization(arr);
    }
}
