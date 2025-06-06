package Arrays.Easy;

public class RemoveDuplicatesInPlaceInSortedArr {

    public static int solve(int[] arr) {
        int n=arr.length;
        int left=0;
        for(int i=1;i<n;i++) {
            if(arr[left]!=arr[i]) {
                left++;
                arr[left] = arr[i];
            }
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3,3,3,3,4,4};
        int ans = solve(arr); // TC: O(n), SC: O(1)
        System.out.println(ans);
        for(int num : arr)
            System.out.print(num + ", ");
    }
}
