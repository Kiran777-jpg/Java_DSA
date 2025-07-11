package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllSubsequences {

    private static void utilGenerateSequences(int i, String temp, String s, List<String> ans) {
        if(i==s.length()) {
            ans.add(temp);
            return;
        }
        utilGenerateSequences(i+1, temp+s.charAt(i), s, ans);
        utilGenerateSequences(i+1, temp, s, ans);
    }

    private static List<String> generateSequences(String s) {
        List<String> ans=new ArrayList<>();
        utilGenerateSequences(0, "", s, ans);
        return ans;
    }

    private static void utilGenerateSequences2(int start, String temp, String s, List<String> ans) {
        ans.add(temp);
//        if(start==s.length()) return;
        for(int i=start;i<s.length();i++) {
            utilGenerateSequences2(i+1, temp+s.charAt(i), s, ans);
        }
    }

    private static List<String> generateSequences2(String s) {
        List<String> ans=new ArrayList<>();
        utilGenerateSequences2(0, "", s, ans);
        return ans;
    }

    static ArrayList<String> usingBits(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    private static void recursion2(int idx, int[] nums, List<Integer> temp) {
        System.out.println(temp);
        for(int i=idx;i<nums.length;i++) {
            temp.add(nums[i]);
            recursion2( i+1, nums, temp);
            temp.removeLast();
        }
    }


    private static void integerSubsequences() {
        int[] nums = {4,2,10,5,1,3};
        List<Integer> temp = new ArrayList<>();
        recursion2(0, nums, temp);
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = generateSequences(s);
        System.out.println(ans);

        ans = generateSequences2(s);
        System.out.println(ans);

        ans = usingBits(s);
        System.out.println(ans);

        integerSubsequences();
    }
}
