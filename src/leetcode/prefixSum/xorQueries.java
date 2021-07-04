package leetcode.prefixSum;

/**
 * 1310. 子数组异或查询
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 */
public class xorQueries {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] ^ arr[i-1];
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0] + 1;
            int right = queries[i][1] + 1;
            res[i] = sum[right] ^ sum[left-1];
        }
        return res;
    }

    public static void main(String[] args) {
        xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}});
    }
}
