package DynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class UniquePathsWithBlocksGrid {
    private static int dfs(int i, int j, int[][] dp, int[][] matrix) {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(matrix[i][j]==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=dfs(i, j-1, dp, matrix)+dfs(i-1,j, dp, matrix);
    }
    private static void memoization(int n, int m, int[][] matrix) {
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        int ans=dfs(n-1,m-1, dp, matrix);
        System.out.println(ans);
    }

    private static void tabulation(int n, int m, int[][] matrix) {
        int[][] dp=new int[n][m];
        int i=0, j=0;
        while(j<m && matrix[0][j]!=-1)  {
            dp[0][j]=1;
            j++;
        }
        while(i<n && matrix[i][0]!=-1) {
            dp[i][0]=1;
            i++;
        }
        for(i=1;i<n;i++) {
            for(j=1;j<m;j++) {
                if(matrix[i][j]==-1) dp[i][j]=0;
                else dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    private static void spaceOptimization(int n, int m, int[][] matrix) {
        int[] prev=new int[m];
        int[] curr=new int[m];
        boolean rowBlock=false, colBlock=false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0) {
                    if(matrix[i][j]==-1) rowBlock=true;
                    if(!rowBlock) prev[j]=1;
                    else prev[j]=0;
                }
                else if(j==0) {
                    if(matrix[i][j]==-1) colBlock=true;
                    if(!colBlock) curr[i]=1;
                    else curr[i]=0;
                }
                else {
                    curr[j]=prev[j]+curr[j-1];
                }
            }
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
        int[][] matrix={{0,0,0},{0,-1,0},{0,0,0}};
        memoization(n,m, matrix);  // TC: O(n*m), SC: O(n*m)+O(n+m)
        tabulation(n,m, matrix);   // TC: O(n*m), SC: O(n*m)
        spaceOptimization(n,m, matrix);  // TC: O(n*m), SC: O(m)+O(m)
    }
}
