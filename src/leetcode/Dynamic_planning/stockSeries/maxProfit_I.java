package leetcode.Dynamic_planning.stockSeries;

/**
 * @Author Yang
 * @Date 2021/4/11 17:58
 * @Description 121. 买卖股票的最佳时机
 * dp[i][j] 表示第i天，对股票持有情况下的最大金额。
 * 买卖的次数只有一次
 */
public class maxProfit_I {
    public static int maxProfit_I(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];   // 天数 -- 状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        maxProfit_I(new int[]{7,1,5,3,6,4});
    }
}
