package Arrays.Easy;

public class AllZerosToEnd {

    public static void solve(int[] arr) {
        int left = 0, right = 0;
        while(arr[left] != 0) left++;
        while(right < arr.length && left < arr.length) {
            if(arr[right] != 0 && left < right) {
                arr[left] = arr[right];
                arr[right] = 0;
                while(arr[left] != 0) left++;
            }
            right++;
        }
    }

    public static void optimize(int[] arr) {
        int left = 0, n=arr.length;
        while(left < n && arr[left] != 0) left++;
        if(left==n) return;
        int right = left+1;
        while(right < arr.length) {
            if(arr[right] != 0 ) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,0,1};
        solve(arr);  // TC: O(n)+O(x)+O(n-x) ~ O(2n), SC: O(1)     x -> no of zeros in array
        for(int num : arr)
            System.out.print(num + ", ");
        System.out.println();

        arr = new int[]{1,0,2,3,0,4,0,1};
//        arr = new int[]{1,4,5,6,7,8,8,9};
        optimize(arr);  // TC: O(n)+O(x)+O(n-x) ~ O(2n), SC: O(1)     x -> no of zeros in array
        for(int num : arr)
            System.out.print(num + ", ");
    }
}
