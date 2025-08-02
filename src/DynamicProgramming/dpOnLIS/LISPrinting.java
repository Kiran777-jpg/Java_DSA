package DynamicProgramming.dpOnLIS;

import java.util.Arrays;

public class LISPrinting {

    private static void tabulationForLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i])
                    dp[i]=Math.max(dp[i], 1+dp[j]);
            }
            maxi=Math.max(maxi, dp[i]);
        }
        System.out.println(maxi);
    }

    private static void printingLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp, 1);
        int maxi=0, last_idx=0;

        for(int i=0;i<n;i++) {
            hash[i]=i;
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[i]<1+dp[j]) {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(maxi<dp[i]) {
                maxi=dp[i];
                last_idx=i;
            }
        }

        int[] ans = new int[maxi];
        int idx = maxi-1;
        while(hash[last_idx] != last_idx) {
            ans[idx]=arr[last_idx];
            last_idx=hash[last_idx];
            idx--;
        }
        ans[0]=arr[last_idx];
        for(int x : ans)
            System.out.print(x+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8};
        tabulationForLIS(arr);
        printingLIS(arr);
    }
}
