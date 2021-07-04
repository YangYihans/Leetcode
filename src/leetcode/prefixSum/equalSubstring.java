package leetcode.prefixSum;

/**
 * 1208. 尽可能使字符串相等
 */
public class equalSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] sum = new int[len + 1];
        /**
         * 前缀和表示需要操做的代价，从1开始。
         */
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + Math.abs(ss[i-1] - tt[i-1]);
        }
        int left = 1;
        int right = len;
        while (left < right) {
            /**
             * mid 表示的是操作的区间长度
             */
            int mid = left + right + 1 >> 1;
            if (check(sum, mid, maxCost)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        /**
         * 二分出来的滑动窗口的长度，返回的时候需要再次检查，因为可能没有符合条件的有效滑动窗口长度。
         */
        return check(sum, right, maxCost) ? right : 0;
    }

    private boolean check(int[] sum, int mid, int maxCost) {
        for(int i = mid; i < sum.length; i++){
            int tot = sum[i] - sum[i - mid];
            if(tot <= maxCost){
                return true;
            }
        }
        return false;
    }
}
