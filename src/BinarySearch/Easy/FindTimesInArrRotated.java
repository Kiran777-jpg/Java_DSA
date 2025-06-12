package BinarySearch.Easy;

public class FindTimesInArrRotated {

    public static int findKRotation(int[] arr) {
        int n=arr.length;
        int start=0, end=n-1;
        int ans=Integer.MAX_VALUE, idx=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[end])
                return start;
            if(arr[start]<=arr[mid]) {
                if(arr[start]<ans) {
                    ans=arr[start];
                    idx=start;
                }
                start=mid+1;
            }
            else {
                if(arr[mid]<ans) {
                    ans=arr[mid];
                    idx=mid;
                }
                end=mid-1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findKRotation(arr);  // same as finding the min element, TC: O(logn), SC: O(1)
        System.out.println(ans);
    }
}
