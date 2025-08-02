package DynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j]=lcs(i-1, j-1, s1, s2, dp) + 1;
        return dp[i][j]=Math.max(lcs(i, j-1, s1, s2, dp), lcs(i-1, j, s1, s2, dp));
    }

    private static void memoization(String s1, String s2) {
        int n=s1.length(), m=s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        int ans = lcs(n, m, s1, s2, dp);
        System.out.println(ans);
    }

    private static void tabulation(String s1, String s2) {
        int n=s1.length(), m=s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) dp[i][j]=0;
                else {
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    private static void spaceOptimization(String s1, String s2) {
        int n=s1.length(), m=s2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) curr[j]=0;
                else {
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        curr[j]=prev[j-1]+1;
                    else
                        curr[j]=Math.max(curr[j-1], prev[j]);
                }
            }
            prev=curr;
        }
        System.out.println(prev[m]);
    }

    public static void main(String[] args) {
//        String s1 = "adebc";
//        String s2 = "dcadb";
        String s1 = "adacbda";
        String s2 = "adbcada";
        memoization(s1, s2);
        tabulation(s1, s2);
        spaceOptimization(s1, s2);
    }
}
