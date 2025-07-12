package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumbersLetterCombinations {
    private static void recursion(int idx, String temp, String[] mapping, String digits, List<String> ans) {
        if(idx==digits.length()) {
            ans.add(temp);
            return;
        }
        String s=mapping[digits.charAt(idx)-'0'];
        for(int i=0;i<s.length();i++) {
            recursion(idx+1, temp+s.charAt(i), mapping, digits, ans);
        }
    }
    private static void letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String[] mapping = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recursion(0, "", mapping, digits, ans);
        for(String s : ans)
            System.out.print(s + ", ");
    }

    public static void main(String[] args) {
        String digits = "234";
        letterCombinations(digits); // TC: O(2^n)*K, SC:O(k)
    }
}
