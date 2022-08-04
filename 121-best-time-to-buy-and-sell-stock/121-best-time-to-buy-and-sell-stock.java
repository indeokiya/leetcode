class Solution {
    public int maxProfit(int[] prices) {
        int local_min = prices[0];
        int local_profit = 0;
        
        for (int price: prices) {
            if (price < local_min) {
                local_min = price;
            } else if (price > local_min) {
                int tmp_profit = price - local_min;
                if (tmp_profit > local_profit) {
                    local_profit = tmp_profit;
                }
            }
        }
        return local_profit;
    }
}