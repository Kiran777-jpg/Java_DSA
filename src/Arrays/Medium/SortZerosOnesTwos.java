package Arrays.Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class SortZerosOnesTwos {

    public static void sortArray(ArrayList<Integer> arr) {
        int n=arr.size();
        int it=0, left=0, right=n-1;
        while(it<=right)
        {
            if(arr.get(it)==0) {
                int temp=arr.get(left);
                arr.set(left, arr.get(it));
                arr.set(it, temp);
                it++;
                left++;
            }
            else if(arr.get(it)==2) {
                int temp=arr.get(right);
                arr.set(right, arr.get(it));
                arr.set(it, temp);
                right--;
            }
            else
                it++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr);  // TC: O(n), SC: O(n), Dutch National Flag Algorithm
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
