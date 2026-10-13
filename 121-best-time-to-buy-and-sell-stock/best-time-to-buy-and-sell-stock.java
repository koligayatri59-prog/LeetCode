class Solution {
    public int maxProfit(int[] prices) {

        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

           minPrices=Math.min(minPrices,price);

           int profit=price-minPrices;
           maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}