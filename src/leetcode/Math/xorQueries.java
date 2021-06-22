package leetcode.Math;
/**
 * @Author Yang
 * @Date 2021/5/12 9:12
 * @Description 1310. 子数组异或查询
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 */
import java.util.*;
public class xorQueries {
    public static int[] xorQueries(int[] arr, int[][] queries){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            query(arr, queries, start, end, res);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void query(int[] arr, int[][] queries, int start, int end, List<Integer> res) {
        int result = 0;
        for(int i = start; i <= end; i++){
            result ^= arr[i];
        }
        res.add(result);
    }

    public static void main(String[] args) {
        System.out.println(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}}));
    }
}
