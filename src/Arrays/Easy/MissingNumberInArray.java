package Arrays.Easy;

public class MissingNumberInArray {

    public static int solve(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for(int i=0;i<n-1;i++) {
            xor1 ^= arr[i];
            xor2 ^= (i+1);
        }
        xor2 ^= n;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int n = 5;
        System.out.println(solve(arr, n)); // TC: O(n), SC: O(1)
    }
}
