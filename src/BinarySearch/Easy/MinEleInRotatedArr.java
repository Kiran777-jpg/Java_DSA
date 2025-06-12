package BinarySearch.Easy;

public class MinEleInRotatedArr {

    public static int findMin(int[] arr) {
        int n=arr.length;
        int start=0, end=n-1;
        int ans=Integer.MAX_VALUE;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[mid]) {
                ans=Math.min(ans, arr[start]);
                start=mid+1;
            }
            else {
                ans=Math.min(ans, arr[mid]);
                end=mid-1;
            }
        }
        return ans;
    }

    public static int findMin2(int[] arr) {
        int n=arr.length;
        int start=0, end=n-1;
        int ans=Integer.MAX_VALUE;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[end])
                return arr[start];
            if(arr[start]<=arr[mid]) {
                ans=Math.min(ans, arr[start]);
                start=mid+1;
            }
            else {
                ans=Math.min(ans, arr[mid]);
                end=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);  // TC: O(logn), SC:O(1)
        System.out.println(ans);
        ans = findMin2(arr);  // TC: O(logn), SC:O(1)
        System.out.println(ans);
    }
}
