package leetcode.prefixSum;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */
public class canEat {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        int m = candiesCount.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m + 1];
        /**
         * 前缀和
         */
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int type = queries[i][0];
            int day = queries[i][1] + 1;
            int cap = queries[i][2];
            /**
             * 最快的时间，吃到第i类糖果的时间是吃完前面所有i-1类糖果的时间 + 1.
             * 因为可能存在不能整除(恰好吃完的情况)
             */
            long a = sum[type] / cap + 1;
            /**
             * 最慢的时间，一天只吃一个糖果。
             */
            long b = sum[type + 1];
            ans[i] = a <= day && day <= b;
        }
        return ans;
    }
}
