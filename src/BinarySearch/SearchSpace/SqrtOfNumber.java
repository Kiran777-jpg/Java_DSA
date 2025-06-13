package BinarySearch.SearchSpace;

public class SqrtOfNumber {

    public static int floorSqrt(int n) {
        int start = 1, end = n-1;
        while (start<=end) {
            long mid = start+(end-start) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                start = (int)(mid + 1);
            } else {
                end = (int)(mid - 1);
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int n = 28;
//        int n = 36;
        int ans = floorSqrt(n);
        System.out.println(ans);
    }
}
