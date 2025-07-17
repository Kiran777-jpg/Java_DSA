package DynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class MinPathSum {

    private static int dfs(int i, int j, int[][] grid, int[][] dp) {
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=dfs(i-1, j, grid, dp);
        int left=dfs(i, j-1, grid, dp);
        return dp[i][j]=Math.min(up, left)+grid[i][j];
    }
    private static void memoization(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        int ans=dfs(n-1,m-1, grid, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 && j==0) {
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i>0) up=dp[i-1][j];
                if(j>0) left=dp[i][j-1];
                dp[i][j]=Math.min(up, left)+grid[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    private static void spaceOptimization(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dp=new int[n][m];
        int[] prev=new int[m];
        for(int i=0;i<n;i++) {
            int[] curr=new int[m];
            for(int j=0;j<m;j++) {
                if(i==0 && j==0) {
                    curr[j] = grid[i][j];
                    continue;
                }
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i>0) up=prev[j];
                if(j>0) left=curr[j-1];
                curr[j]=Math.min(up, left)+grid[i][j];
            }
            prev=curr;
        }
        System.out.println(prev[m-1]);
    }

    private static void spaceOptimization2(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dp=new int[n][m];
        int[] prev=new int[m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 && j==0) {
                    prev[j] = grid[i][j];
                    continue;
                }
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i>0) up=prev[j];
                if(j>0) left=prev[j-1];
                prev[j]=Math.min(up, left)+grid[i][j];
            }
        }
        System.out.println(prev[m-1]);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid = {{1,3},{5,6}};
        memoization(grid);  // TC: O(n*m), SC: O(n*m)+O(n+m)
        tabulation(grid);   // TC: O(n*m), SC: O(n*m)
        spaceOptimization(grid);  // TC: O(n*m), SC: O(m)+O(m)
        spaceOptimization2(grid);  // TC: O(n*m), SC: O(m)
    }
}
