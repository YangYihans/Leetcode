package leetcode.Dynamic_planning.stockSeries;
/**
 * @Author Yang
 * @Date 2021/4/11 22:36
 * @Description 188. 买卖股票的最佳时机 IV
 * 最多可以购买k次
 * 这个和III是一样的解题思路
 */
public class maxProfit_IV {
    public static int maxProfit_IV(int[] prices, int max_k){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][][] dp = new int[len][max_k+1][2];  // 天数---交易次数----状态
        for(int i = 0; i < len; i++){
            for(int k = 1; k <= max_k; k++){
                if(i == 0){
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);  // 卖
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]); // 买
            }
        }
        return dp[len-1][max_k][0];
    }

    public static void main(String[] args) {
        maxProfit_IV(new int[]{3,3,5,0,0,3,1,4}, 2);
    }
}
