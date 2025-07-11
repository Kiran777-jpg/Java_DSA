package recursion.subsequencePatterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {

    // method - 1
    private static void utilBinaryStrings(int n, String s, List<String> ans) {
        if(s.length()==n)
        {
            ans.add(s);
            return;
        }
        utilBinaryStrings(n, s+'0', ans);
        if(s.length()==0 || s.charAt(s.length()-1)!='1')
            utilBinaryStrings(n, s+'1', ans);
    }

    private static List<String> generateBinaryStrings(int n) {
        List<String> ans=new ArrayList<>();
        utilBinaryStrings(n, "", ans);
        return ans;
    }

    //method - 2
    private static void utilBinaryStrings2(int idx, int n, StringBuffer s, List<String> ans) {
        if(idx>=n)
        {
            ans.add(s.toString());
            return;
        }
        utilBinaryStrings2(idx+1, n, s, ans);
        s.setCharAt(idx, '1');
        utilBinaryStrings2(idx+2, n, s, ans);
        s.setCharAt(idx, '0');
    }

    private static List<String> generateBinaryStrings2(int n) {
        List<String> ans=new ArrayList<>();
        StringBuffer s = new StringBuffer();
        for(int i=0;i<n;i++)
            s.append('0');
        utilBinaryStrings2(0, n, s, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n=3;
        List<String> binaryStrings = generateBinaryStrings(n);
        System.out.println(binaryStrings);

        binaryStrings = generateBinaryStrings2(n);
        System.out.println(binaryStrings);
    }
}
