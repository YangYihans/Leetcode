package leetcode.Dynamic_planning;
/*
力扣70.爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
斐波那契数列：dp[i] = dp[i-1] + dp[i-2]
 */
public class climbStairsTest70 {
    public static void main(String[] args) {
        climbStairsTest70 t1 = new climbStairsTest70();
       // System.out.print(t1.climbStairs(4));
       // System.out.print(t1.fib(4));
        int [] rob = new int []{2,7,9,3,1};
        System.out.print(t1.rob(rob));
    }

    /**
     * 爬楼梯，每次只能上一级或者两级， 典型的斐波那契。
     * @param n
     * @return
     */
    public int climbStairs(int n )
    {
        if(n==1)
            return 1;
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列
     * @param N
     * @return
     */
    public int fib(int N)
    {
        if(N == 0)
            return 0;
        if(N == 1)
            return 1;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
    public int rob(int [] nums)
    {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0]>nums[1]?nums[0]:nums[1];
        int [] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
        for(int i = 2; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
