package BinarySearch.Easy;

public class FindEleInRotatedSortedArrDuplicates {

    public static boolean binarySearch(int[] a, int target) {
        int n=a.length;
        int start=0, end=n-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(a[mid]==target)
                return true;

            //edge case
            if(a[start]==a[mid] && a[mid]==a[end]) {
                start++;
                end--;
                continue;
            }

            if(a[start]<=a[mid]) {
                if(a[start]<=target && target<=a[end])
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
        return false;
    }

    public static void main(String[] args) {
        int[] a = {7,8,1,2,3,3,3,4,5,6};
//        int[] a = {3,1,2,3,3,3};   // -> Debug this edge case
//        int target = 2;
        int target = 3;
        System.out.println(binarySearch(a, target));  // TC:O(logn), SC:O(1)
    }
}
