package DynamicProgramming.dpOnGrids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NinjaTraining {
    private static int dfs(int day, int last, int[][] matrix, int[][] dp) {
        if(dp[day][last]!=-1) return dp[day][last];
        if(day==0) {
            int maxi=0;
            for(int i=0;i<3;i++) {
                if(i!=last)
                    maxi=Math.max(maxi, matrix[day][i]);
            }
            return dp[day][last]=maxi;
        }
        int ans=0;
        for(int k=0;k<3;k++) {
            if(k!=last) {
                ans=Math.max(ans, dfs(day-1, k, matrix, dp)+matrix[day][k]);
            }
        }
        return dp[day][last]=ans;
    }

    private static void tabulation(int[][] matrix) {
        int n= matrix.length, m=matrix[0].length;
        int[][] dp=new int[n][4];
        dp[0][0]=Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1]=Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2]=Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3]=Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for(int i=1;i<n;i++) {
            for(int j=0;j<4;j++) {
                dp[i][j]=0;
                for(int k=0;k<3;k++) {
                    if(k!=j) {
                        dp[i][j]=Math.max(dp[i][j], dp[i-1][k]+matrix[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[n-1][3]);
    }

    private static void spaceOptimization(int[][] matrix) {
        int n= matrix.length, m=matrix[0].length;
        int[] prev=new int[4];
        prev[0]=Math.max(matrix[0][1], matrix[0][2]);
        prev[1]=Math.max(matrix[0][0], matrix[0][2]);
        prev[2]=Math.max(matrix[0][0], matrix[0][1]);
        prev[3]=Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for(int i=1;i<n;i++) {
            int[] curr=new int[4];
            for(int j=0;j<4;j++) {
                curr[j]=0;
                for(int k=0;k<3;k++) {
                    if(k!=j) {
                        curr[j]=Math.max(curr[j], prev[k]+matrix[i][k]);
                    }
                }
            }
            prev=curr;
        }
        System.out.println(prev[3]);
    }


    private static void ninjaTraining(int[][] matrix) {
        int n= matrix.length, m=matrix[0].length;
        int ans=0;
        int[][] dp=new int[n][4];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        ans=dfs(n-1, 3, matrix, dp);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[][] matrix = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        ninjaTraining(matrix);  //  TC: O(N*4*3), SC: O(N)+O(N*4);
        tabulation(matrix);  //  TC: O(N*4*3), SC: O(N*4);
        spaceOptimization(matrix);   //  TC: O(N*4*3), SC: O(4);
    }
}
