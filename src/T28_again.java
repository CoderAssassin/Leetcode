/**
 * @Author:Aliyang
 * @Data: Created in 下午3:43 18-7-15
 * best-time-to-buy-and-sell-stock-iii：二刷
 **/
public class T28_again {

    public int maxProfit(int[] prices) {

        int buy_1=Integer.MIN_VALUE,sell_1=0,
                buy_2=Integer.MIN_VALUE,sell_2=0;

        for (int i=0;i<prices.length;i++){
            buy_1=Math.max(buy_1,0-prices[i]);//买第一只股票后，目前最大利润，是负的，因为开始钱为0
            sell_1=Math.max(sell_1,buy_1+prices[i]);//卖出第一只股票后目前最大利润，当前的股票价加上买第一只股票后的最大利润
            buy_2=Math.max(buy_2,sell_1-prices[i]);//买第二只股票后，目前最大利润，因为买第二只股票要付钱，所以是减
            sell_2=Math.max(sell_2,buy_2+prices[i]);//卖出第二只股票后，目前最大利润
        }
        return sell_2;
    }
}
