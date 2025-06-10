package Arrays.Medium;

public class StockBuyAndSell {

    public static int maxProfit(int[] arr) {
        int n=arr.length;
        int buy=Integer.MAX_VALUE, profit=Integer.MIN_VALUE;
        for(int curr_price : arr) {
            buy=Math.min(buy, curr_price);
            profit=Math.max(profit, curr_price-buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr);
        System.out.println(maxPro);
    }
}
