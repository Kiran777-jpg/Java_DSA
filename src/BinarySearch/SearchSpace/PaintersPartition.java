package BinarySearch.SearchSpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PaintersPartition {
    public static boolean isValid(ArrayList<Integer> boards, int painters, int time) {
        int timeByPainters=0;
        int actualPainters=1;
        for(int i=0;i<boards.size();i++) {
            if(timeByPainters+boards.get(i)>time) {
                actualPainters++;
                timeByPainters=boards.get(i);
            }
            else
                timeByPainters+=boards.get(i);
        }
        return actualPainters==painters;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n=boards.size();
        int start=Collections.max(boards);
        int end=boards.stream().mapToInt(Integer::intValue).sum();
        int ans=-1;

        while(start<=end) {
            int mid=start+(end-start)/2;
            if(isValid(boards, k, mid)) {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
//        int k = 2;
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(5, 5, 5, 5));
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println(ans);
    }
}
