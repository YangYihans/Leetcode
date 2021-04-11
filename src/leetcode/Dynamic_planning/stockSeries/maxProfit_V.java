package leetcode.Dynamic_planning.stockSeries;
/**
 * @Author Yang
 * @Date 2021/4/11 22:53
 * @Description 309. 最佳买卖股票时机含冷冻期
 * 309. 最佳买卖股票时机含冷冻期
 * 含有冻结期就买入的话 就只能
 */
public class maxProfit_V {
    public static int maxProfit_V(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        for(int i = 0; i < len; i++){
            if(i == 0){  // base-case
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            if(i == 1){  // base-case 对于第1天， dp[i][1]是头一天持有或者当前天买入的最大值， 这样才能把i-2的溢出消除
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        maxProfit_V(new int[]{1,2,3,0,2});
    }
}
