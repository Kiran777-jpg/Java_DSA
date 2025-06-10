package Arrays.Medium;

public class MajorityElement {

    public static int majorityElement(int[] arr) {
        int n=arr.length;
        int count=0, value=-1;
        for(int it : arr) {
            if(count==0) {
                value=it;
                count=1;
            }
            else if(value!=it)
                count--;
            else
                count++;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);  // TC: O(n), SC:O(1)
        System.out.println(ans);
    }
}
