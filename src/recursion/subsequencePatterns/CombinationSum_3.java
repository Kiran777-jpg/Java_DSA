package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_3 {

    private static void recursion(int idx, int sum, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(sum==n) {
            if(temp.size()==k)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()==k || idx>9) return;
        temp.add(idx);
        recursion(idx+1, sum+idx, n, k, temp, ans);
        temp.removeLast();
        recursion(idx+1, sum, n, k, temp, ans);
    }

    private static void combinationSum(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(1, 0, n, k, new ArrayList<>(), ans);
        for(List<Integer> list : ans)
            System.out.println(list);
    }

    private static void recursion2(int idx, int sum, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(sum==n) {
            if(temp.size()==k)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()==k) return;
        for(int i=idx;i<=9;i++) {
            if(sum>n) break;
            temp.add(i);
            recursion2(i+1, sum+i, n, k, temp, ans);
            temp.removeLast();
        }
    }

    private static void combinationSum2(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion2(1, 0, n, k, new ArrayList<>(), ans);
        for(List<Integer> list : ans)
            System.out.println(list);
    }

    public static void main(String[] args) {
        int k=3, n=7;
//        int k=3, n=9;
        combinationSum(n, k);  // TC: O(2^k)*O(k), SC:O(k)
        combinationSum2(n, k); // TC: O(2^k)*O(k), SC:O(k)
    }
}
