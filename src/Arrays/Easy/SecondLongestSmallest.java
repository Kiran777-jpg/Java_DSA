package Arrays.Easy;

public class SecondLongestSmallest {

    public static int[] solve(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int second_maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int second_mini = Integer.MAX_VALUE;
        int[] ans = new int[2];
        for(int num : arr) {
            if(num > maxi) {
                second_maxi = maxi;
                maxi = num;
            }
            else if(num < maxi && num > second_maxi)
                second_maxi = num;

            if(num < mini) {
                second_mini = mini;
                mini = num;
            }
            else if(num > mini && num < second_mini)
                second_mini = num;
            System.out.println(num+", "+second_maxi+", "+maxi);
        }
        ans[0]=second_mini;
        ans[1]=second_maxi;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,7,7};
        int[] ans = solve(arr);  // TC: O(n), SC: O(1)
        for(int num : ans)
            System.out.println(num);
    }
}
