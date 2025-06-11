package Arrays.Medium;
import java.util.ArrayList;

public class LeaderInArrFromRightSide {

    public static ArrayList<Integer> printLeadersBruteForce(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i]>maxi) {
                ans.add(arr[i]);
                maxi=arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]=  {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> ans= printLeadersBruteForce(arr); // TC: O(n), SC:O(n)
        for(int num : ans)
            System.out.println(num + " ");
    }
}
