import java.util.Arrays;

public class Stocks {

    public static int maxProfit(int[] prices) {
        int curr = 1;
        int maxProfit = 0;

        while(curr<prices.length) {
            int diff = prices[curr] - prices[curr-1];
            if (diff > 0) {
                maxProfit += diff;
            }
            curr++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Stocks");
        int[] a = {7,1,5,3,6,4};
        System.out.println("Input:\t"+ Arrays.toString(a));

        int profit = maxProfit(a);
        System.out.println("Output:\t"+ profit);
    }
}