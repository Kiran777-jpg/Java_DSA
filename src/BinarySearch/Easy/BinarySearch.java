package BinarySearch.Easy;

public class BinarySearch {

    public static int binarySearch(int[] a, int target) {
        int n=a.length;
        int low=0, high=n-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(a[mid]==target)
                return mid;
            if(target<a[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 7;
        System.out.println(binarySearch(a, target));  // TC:O(logn), SC:O(1)
    }
}
