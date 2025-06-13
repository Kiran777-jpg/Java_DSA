package BinarySearch.OneDArrays;

public class FindEleInRotatedSortedArr {

    public static int binarySearch(int[] a, int target) {
        int n=a.length;
        int start=0, end=n-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(a[mid]==target)
                return mid;

            if(a[start]<=a[mid]) {
                if(a[start]<=target && target<=a[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else {
                if(a[mid]<=target && target<=a[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2,3};
        int target = 0;
        System.out.println(binarySearch(a, target));  // TC:O(logn), SC:O(1)
    }
}
