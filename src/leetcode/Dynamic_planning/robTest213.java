package leetcode.Dynamic_planning;

import java.util.Arrays;

/*
力扣213：打家劫舍II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class robTest213 {
    public static void main(String[] args) {
        robTest213 t1 = new robTest213();
        int[] nums = new int[]{1,2,1,1};
        System.out.println(t1.rob(nums));
    }

    /**
     * 模拟环形队列问题，直接拆成两个队列，一个是【0，n-1】，一个是【1，n】。
     * @param nums
     * @return
     */
    public int rob(int[] nums)
    {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0],nums[1]);
        int maxMoney = 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < len-1; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        maxMoney = dp[len-2];
        Arrays.fill(dp,0);
        dp[1] = nums[1];
        for(int i = 2; i < len; i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        if(dp[len-1] > maxMoney)
            return dp[len-1];
        return maxMoney;
    }
    public int rob(TreeNode root)
    {
        if(root == null)
            return 0;
        int maxMoney = root.val;
        if(root.left != null)
        {
            maxMoney += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null)
        {
            maxMoney += rob(root.right.left) + rob(root.right.left);
        }
        return Math.max(maxMoney,rob(root.left)+rob(root.right));
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }
}
