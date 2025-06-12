package BinarySearch.Easy;

public class LowerBound {

    public static int binarySearch(int[] a, int target) {
        int n=a.length;
        int ans=-1;
        int low=0, high=n-1;
        while(low<=high) {
            int mid=(low+high)/2;
            System.out.println(mid+", "+low+", "+high);
            if(a[mid]>=target) {
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 13;
        System.out.println(binarySearch(a, target));  // TC:O(logn), SC:O(1)
    }
}
