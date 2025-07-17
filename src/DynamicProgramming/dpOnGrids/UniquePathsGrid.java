package DynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class UniquePathsGrid {
    private static int dfs(int i, int j, int[][] dp) {
        if(i==0 || j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=dfs(i, j-1, dp)+dfs(i-1,j, dp);
    }
    private static void memoization(int n, int m) {
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        int ans=dfs(n-1,m-1, dp);
        System.out.println(ans);
    }

    private static void tabulation(int n, int m) {
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0||j==0) dp[i][j]=1;
                else {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    private static void spaceOptimizatoin(int n, int m) {
        int[] prev=new int[m];
        Arrays.fill(prev, 1);
        int[] curr=new int[m];
        curr[0]=1;
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++)
                curr[j]=prev[j]+curr[j-1];
            prev=curr;
        }
        System.out.println(prev[m-1]);
    }

    private static void spaceOptimizatoin2(int n, int m) {
        int[] prev=new int[m];
        Arrays.fill(prev, 1);
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++)
                prev[j]=prev[j]+prev[j-1];
        }
        System.out.println(prev[m-1]);
    }

    public static void main(String[] args) {
//        int n=3, m=2;
        int n=3, m=3;
        memoization(n,m);  // TC: O(n*m), SC: O(n*m)+O(n+m)
        tabulation(n,m);   // TC: O(n*m), SC: O(n*m)
        spaceOptimizatoin(n,m);  // TC: O(n*m), SC: O(m)+O(m)
        spaceOptimizatoin2(n,m);  // TC: O(n*m), SC: O(m)
    }
}
