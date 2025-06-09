package Arrays.Easy;

public class FindAppearOnceInArray {

    public static int getSingleElement(int[] arr) {
        int xor = 0;
        for(int it : arr)
            xor ^= it;
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr); // TC: O(n), SC: O(1)
        System.out.println(ans);
    }
}
