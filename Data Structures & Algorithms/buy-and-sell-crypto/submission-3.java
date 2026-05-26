class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] preFixMin = new int[prices.length];
        preFixMin[0] = prices[0];
        for(int i=1; i<prices.length; i++) {
            preFixMin[i] = Math.min(preFixMin[i-1], prices[i]);
        }

        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - preFixMin[i]);
        }

        return maxProfit;
    }
}
