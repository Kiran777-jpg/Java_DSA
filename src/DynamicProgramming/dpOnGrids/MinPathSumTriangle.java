package DynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class MinPathSumTriangle {

    private static int dfs(int i, int j, int[][] triangle, int[][] dp) {
        if(i==(triangle.length-1)) return triangle[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int l=dfs(i+1, j, triangle, dp);
        int r=dfs(i+1, j+1, triangle, dp);
        return dp[i][j]=Math.min(l, r)+triangle[i][j];
    }
    private static void memoization(int[][] triangle) {
        int n=triangle.length, m=triangle[0].length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        int ans=dfs(0,0, triangle, dp);
        System.out.println(ans);
    }

    private static void tabulation(int[][] triangle) {
        int n=triangle.length, m=triangle[0].length;
        int[][] dp=new int[n][n];
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                triangle[i][j]=Math.min(triangle[i+1][j], triangle[i+1][j+1])+triangle[i][j];
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++)
                System.out.print(triangle[i][j]+" ");
            System.out.println();
        }
        System.out.println(triangle[0][0]);
    }

    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        memoization(triangle);
        tabulation(triangle);
    }
}
