package DynamicProgramming.dpOnGrids;

public class MinFallingPathSum {

    private static int recursion(int i, int j, int[][] matrix, int[][] dp) {
        if(j<0 || j==matrix.length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];
        int l=recursion(i-1, j-1, matrix, dp);
        int s=recursion(i-1, j, matrix, dp);
        int r=recursion(i-1,j+1, matrix, dp);
        return Math.min(s, Math.min(l,r))+matrix[i][j];
    }

    private static void memoization(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++)
            ans=Math.min(ans, recursion(n-1, i, matrix, dp));
        System.out.println(ans);
    }

    private static void tabulation(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int[][] dp=new int[n][m];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0) dp[i][j]=matrix[i][j];
                else {
                    int l=Integer.MAX_VALUE, s=Integer.MAX_VALUE, r=Integer.MAX_VALUE;
                    if(j>0) l=dp[i-1][j-1];
                    if(j<n-1) r=dp[i-1][j+1];
                    s=dp[i-1][j];
                    dp[i][j]=Math.min(s, Math.min(l, r))+matrix[i][j];
                }
                if(i==n-1)
                    ans=Math.min(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

    private static void spaceOptimization(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int[] prev=new int[m];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int[] curr=new int[m];
            for(int j=0;j<m;j++) {
                if(i==0) curr[j]=matrix[i][j];
                else {
                    int l=Integer.MAX_VALUE, s=Integer.MAX_VALUE, r=Integer.MAX_VALUE;
                    if(j>0) l=prev[j-1];
                    if(j<n-1) r=prev[j+1];
                    s=prev[j];
                    curr[j]=Math.min(s, Math.min(l, r))+matrix[i][j];
                }
                if(i==n-1)
                    ans=Math.min(ans, curr[j]);
            }
            prev=curr;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        memoization(matrix);
        tabulation(matrix);
        spaceOptimization(matrix);
    }
}
