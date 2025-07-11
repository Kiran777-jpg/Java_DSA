package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void utilGenerateParanthesis(int n, int open, int close, String s, List<String> ans) {
        System.out.println(s + ", " + open + ", " + close);
        if(open==n && close==n) {
            ans.add(s);
            return;
        }
        if(open<n)
            utilGenerateParanthesis(n, open+1, close, s+'(', ans);
        if(open>close)
            utilGenerateParanthesis(n, open, close+1, s+')', ans);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        utilGenerateParanthesis(n, 0, 0, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        int n=3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
}
