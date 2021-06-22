package ByteDance.Greedy;

import java.util.Stack;

public class maxProfit {
    public static void main(String[] args)
    {

    }
    public static int maxProfit(int[] prices)
    {
        int len = prices.length;
        if(len == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        int diff = 0;
        int maxProfit = 0;
        for(int i = 1; i < len; i++)
        {
            if(prices[i] > prices[i-1])
            {
                diff =  prices[i] - stack.peek();
                if(diff > maxProfit)
                    maxProfit = diff;
            }
            else
            {
                if(prices[i] < stack.peek())
                {
                    stack.push(prices[i]);
                }
            }
        }
        return maxProfit;
    }
    public static int  maxProfit1(int[] prices)
    {
        int len = prices.length;
        if(len == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        int res = 0;
        for(int i = 1; i < len; i++)
        {
            if(prices[i] > prices[i-1])
            {
                res += prices[i] - stack.pop();
                stack.push(prices[i]);
            }
            else
            {
                stack.pop();
                stack.push(prices[i]);
            }
        }
        return res;
    }
}
