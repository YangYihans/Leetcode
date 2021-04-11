package leetcode.Dynamic_planning.stockSeries;
/**
 * @Author Yang
 * @Date 2021/4/11 18:12
 * @Description 122. 买卖股票的最佳时机 II
 * 买卖的次数有无数次
 */
public class maxProfit_II {
    public static int maxProfit_II(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        maxProfit_II(new int[]{7,1,5,3,6,4});
    }
}
