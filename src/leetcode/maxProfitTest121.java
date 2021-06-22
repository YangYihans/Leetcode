package leetcode;
/*
力扣121：买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
 */
public class maxProfitTest121 {
    public static void main(String[] args) {
        maxProfitTest121 t1 = new maxProfitTest121();
        int[] a = new int[]{7,6,4,3,1};
        System.out.print(t1.maxProfit(a));
    }
    public int maxProfit(int [] prices)
    {
        int n = prices.length;
        int maxProfit = 0;
        for(int i = 0; i < n-1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(prices[i] < prices[j])
                {
                    maxProfit = maxProfit<(prices[j]-prices[i])? prices[j]-prices[i]:maxProfit;
                }
            }
        }
        return maxProfit;
    }
}
