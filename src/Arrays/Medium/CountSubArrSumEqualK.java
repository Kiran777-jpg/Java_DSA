package Arrays.Medium;
import java.util.Map;
import java.util.HashMap;

public class CountSubArrSumEqualK {

    public static int findAllSubarraysWithGivenSum(int[] arr, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int prefixSum=0;
        int count=0;
        hashmap.put(0, 1);
        for(int num : arr) {
            prefixSum+=num;
            int x=prefixSum-k;
            count+=hashmap.getOrDefault(x, 0);
            hashmap.put(prefixSum, hashmap.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 4};
        int[] arr = {3, 1, 2, 4, -2, 1, 1};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println(cnt);
    }
}
