package Arrays.Easy;

public class MaxConsecutiveOnesArray {

    public static int solve(int[] arr) {
        int i = 0;
        int ans = 0, count = 0;
        while(i < arr.length) {
            if(arr[i] == 1)
                count++;
            else
                count = 0;
            ans = Math.max(ans, count);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,1};
        System.out.println(solve(arr)); // TC: O(n), SC: O(1)
    }
}
