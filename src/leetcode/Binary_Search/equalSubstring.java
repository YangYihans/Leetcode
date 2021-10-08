package leetcode.Binary_Search;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 1208. 尽可能使字符串相等
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0）
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。]
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 */
public class equalSubstring {
    public static int equalSubstring(String s, String t, int maxCost){
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[] diff  = new int[s.length()];
        int diffMin = Integer.MAX_VALUE;
        for(int i = 0; i < diff.length; i++){
            diff[i] = Math.abs(charsS[i] - charsT[i]);
            diffMin = Math.min(diff[i], diffMin);
        }
        if(diffMin > maxCost){
            return 0;
        }
        int cost = 0, res = 0, left = 0;
        /**
         * 滑动窗口的思想
         */
        for(int i = 0; i < diff.length; i++){
            cost += diff[i];
            while(cost > maxCost){
                cost -= diff[left];
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    /**
     * 二分的思想实现
     * @param ss
     * @param tt
     * @param max
     * @return
     */
    public static int equalSubstring_II(String ss, String tt, int max){
        int len = ss.length();
        ss = " " + ss;
        tt = " " + tt;
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int[] sum = new int[len+1];
        /**
         * 前缀和数组，任意区间[i, j]的修改成本可以通过sum[j] - sum[i-1]得出
         */
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + Math.abs(s[i] - t[i]);
        }
        int left = 1, right = len;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(canSubstring(sum, mid, max)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return canSubstring(sum, right, max) ? right : 0;
    }

    private static boolean canSubstring(int[] sum, int mid, int max) {
        for(int i = mid; i < sum.length; i++){
            int tot = sum[i] - sum[i - mid];
            if(tot < max){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(equalSubstring_II("ujteygggjwxnfl",  "nstsenrzttikoy",    43));
    }
}









