package Arrays.Easy;
import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

    public static int twoPointersApproach(int[] a, int k) {
        int n=a.length;
        int sum=0, i=0, j=0;
        int ans=0;

        while(j<n) {
            sum+=a[j];
            if(sum==k)
                ans=Math.max(ans, j-i+1);
            while(i<n && sum>=k) {
                sum-=a[i];
                i++;
            }
            j++;
        }
        return ans;
    }

    public static int usingHashing(int[] a, int k) {
        int n=a.length, sum=0;
        int ans=0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++) {
            sum+=a[i];
            if(sum==k)
                ans=i+1;
            if(hashmap.containsKey(sum-k))
                ans=Math.max(ans, i-hashmap.get(sum-k));
            if(!hashmap.containsKey(sum))
                hashmap.put(sum, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2,3,5,1,1,9};
        int k = 10;
        System.out.println(usingHashing(a, k)); // TC: O(n), SC: O(n) ,It works both +ve & -ve numbers.
        System.out.println(twoPointersApproach(a, k)); // TC: O(2*n), SC: O(1) ,It works only for +ve numbers.
    }
}
