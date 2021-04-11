package leetcode.Dynamic_planning.stockSeries;
/**
 * @Author Yang
 * @Date 2021/4/11 23:15
 * @Description 714. 买卖股票的最佳时机含手续费
 * 含手续费，只需要在买入的时候加上这个费用即可。
 */
public class maxProfit_VI {
    public static int maxProfit_VI(int[] prices, int fee){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        for(int i = 0; i < len; i++){
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        maxProfit_VI(new int[]{1,3,2,8,4,9}, 2);
    }
}
