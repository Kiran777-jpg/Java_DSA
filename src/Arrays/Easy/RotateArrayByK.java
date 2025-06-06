package Arrays.Easy;

public class RotateArrayByK {

    public static void solveRightShift(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        int temp[] = new int[k];
        for(int i=n-k;i<n;i++)
            temp[i-(n-k)] = arr[i];
        for(int i=n-k-1;i>=0;i--)
            arr[i+k] = arr[i];
        for(int i=0;i<k;i++)
            arr[i] = temp[i];

        for(int i=0;i<n;i++)
            System.out.print(arr[i]+", ");
    }

    public static void solveLeftShift(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        int temp[] = new int[k];
        for(int i=0;i<k;i++)
            temp[i] = arr[i];
        for(int i=k;i<n;i++)
            arr[i-k] = arr[i];
        for(int i=n-k;i<n;i++)
            arr[i] = temp[i-(n-k)];

        for(int i=0;i<n;i++)
            System.out.print(arr[i]+", ");
        System.out.println();
    }

    public static void rotateArr(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void rightShiftUsingReversalAlgo(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        rotateArr(arr, n-k, n-1);
        rotateArr(arr, 0, n-k-1);
        rotateArr(arr, 0, n-1);

        for(int num : arr)
            System.out.print(num + ", ");
        System.out.println();
    }

    public static void leftShiftUsingReversalAlgo(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        rotateArr(arr, 0, k-1);
        rotateArr(arr, k, n-1);
        rotateArr(arr, 0, n-1);

        for(int num : arr)
            System.out.print(num + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 2;
        solveRightShift(arr, k); // TC: O(n), SC:O(k)
        arr = new int[]{1,2,3,4,5,6,7};
        System.out.println();
        solveLeftShift(arr, k); // TC: O(n), SC:O(k)

        // using Reversal Algorithm
        arr = new int[]{1,2,3,4,5,6,7};
        rightShiftUsingReversalAlgo(arr, k); // TC: O(n), SC:O(1)

        arr = new int[]{1,2,3,4,5,6,7};
        leftShiftUsingReversalAlgo(arr, k); // TC: O(n), SC:O(1)
    }
}
