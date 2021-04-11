package leetcode.Dynamic_planning.stockSeries;
/**
 * @Author Yang
 * @Date 2021/4/11 22:06
 * @Description 123. 买卖股票的最佳时机 III
 * 最多只能完成2笔交易
 * int[][][] dp  天数----交易次数----状态  1 -- 占有
 */
public class maxProfit_III {
    public static int maxProfit_III(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][][] dp = new int[len][3][2];  // 天数---交易次数----状态
        for(int i = 0; i < len; i++){
            for(int k = 1; k <= 2; k++){
                if(i == 0){
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);  // 卖
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]); // 买
            }
        }
        return dp[len-1][2][0];
    }

    public static void main(String[] args) {
        maxProfit_III(new int[]{3,3,5,0,0,3,1,4});
    }
}
