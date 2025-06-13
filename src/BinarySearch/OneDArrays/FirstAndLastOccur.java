package BinarySearch.OneDArrays;

public class FirstAndLastOccur {

    public static int firstOccurrence(int key, int[] v) {
        int n=v.length;
        int low=0, high=n-1;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(v[mid]==key) {
                ans=mid;
                high=mid-1;
            }
            else if(key<v[mid]) {
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

    public static int lastOccurrence(int key, int[] v) {
        int n=v.length;
        int low=0, high=n-1;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(v[mid]==key) {
                ans=mid;
                low=mid+1;
            }
            else if(key<v[mid]) {
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

    public static void main(String args[]) {
        int key = 13;
        int[] v = {3,4,13,13,13,20,40};
        System.out.println(firstOccurrence(key, v));  // TC:O(logn), SC:O(1)
        System.out.println(lastOccurrence(key, v));  // TC:O(logn), SC:O(1)
    }
}
