package Arrays.Medium;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestSuccessiveElementsUsingSorting(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int count=0, last_value=Integer.MIN_VALUE, max_ans=0;
        for(int i=0;i<n;i++) {
            if(a[i]==last_value+1) {
                count++;
                last_value=a[i];
            }
            else {
                count=1;
                last_value=a[i];
            }
            max_ans=Math.max(max_ans, count);
        }
        return max_ans;
    }

    public static int longestSuccessiveElementsUsingHashing(int[] a) {
        int n=a.length;
        int max_ans=0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : a) {
            int count=1;
            int x=num;
            while(hashSet.contains(x-1)) {
                count++;
                x--;
            }
            max_ans=Math.max(max_ans, count);
            hashSet.add(num);
        }
        return max_ans;
    }

    public static int longestSuccessiveElementsUsingHashingOptimize(int[] a) {
        int n=a.length;
        int max_ans=0;
        Set<Integer> hashSet = new HashSet<>();
        for(int it : a)
            hashSet.add(it);
        for(int num : a) {
            if(!hashSet.contains((num-1))) {
                int count=1;
                while(hashSet.contains(num+1)) {
                    count++;
                    num++;
                }
                max_ans=Math.max(max_ans, count);
            }
        }
        return max_ans;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4, 6, 7, 10, 8, 11};
        int ans = longestSuccessiveElementsUsingSorting(a);  // TC: O(nlogn)+O(n), SC:O(1)
        System.out.println(ans);
        ans = longestSuccessiveElementsUsingHashing(a);  // TC: O(n)+O(n), SC:O(n)
        System.out.println(ans);
        ans = longestSuccessiveElementsUsingHashingOptimize(a);  // TC: O(n)+O(n), SC:O(n)
        System.out.println(ans);
    }
}
