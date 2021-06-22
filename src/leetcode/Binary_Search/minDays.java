package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/5/9 10:30
 * @Description 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * 思路和吃香蕉、船的运载能力一样
 */
public class minDays {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n){
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int b : bloomDay){
            left = Math.min(left, b);
            right = Math.max(right, b);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isOk(bloomDay, mid, m , k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isOk(int[] bloomDay, int mid, int m, int k) {
        int count = 0, res = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                count++;
                if(count == k){
                    count = 0;
                    res++;
                    if(res == m){
                        return true;
                    }
                }
            }else{
                count = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }
}
