package BinarySearch.SearchSpace;
import java.util.Arrays;

public class CapacityOfShipPackagesInDdays {

    public static boolean isValid(int[] weights, int expectedDays, int shipWeight) {
//        int sumOfWeight=Arrays.stream(weights).sum();
//        int days=(int)Math.ceil((double)sumOfWeight/(double)shipWeight);
//        return days<=expectedDays;

//        int sum=0;
//        int actualDays=0;
//        for(int i=0;i<weights.length;i++) {
//            if(sum+weights[i]>shipWeight) {
//                actualDays++;
//                sum=weights[i];
//            }
//            else
//                sum+=weights[i];
//            sum+=weights[i];
//            if(sum==shipWeight) {
//                actualDays++;
//                sum=0;
//            }
//            else if(sum>shipWeight) {
//                actualDays++;
//                sum=weights[i];
//            }
//        }
//        if(sum!=0) actualDays++;
//        return actualDays<=expectedDays;

        int sum=0;
        int actualDays=1;
        for(int i=0;i<weights.length;i++) {
            if (sum + weights[i] > shipWeight) {
                actualDays++;
                if(shipWeight==9) {
                }
                sum = weights[i];
            } else
                sum += weights[i];
        }
        return actualDays<=expectedDays;
    }

    public static int solve(int[] weights, int d) {
        int n=weights.length;
        int start=Arrays.stream(weights).min().getAsInt();
        int end=Arrays.stream(weights).sum();
        int ans=-1;

        while(start<=end) {
            int mid=start+(end-start)/2;
            if(isValid(weights, d, mid)) {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int weights[] = {5,4,5,2,3,4,5,6};
        int d = 5;
//        int weights[] = {1,2,3,4,5,6,7,8,9,10};
//        int d = 1;
        System.out.println(solve(weights, d));
    }
}
