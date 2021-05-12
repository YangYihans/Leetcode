package leetcode.Array.prefix;
/**
 * @Author Yang
 * @Date 2021/5/12 10:10
 * @Description 1310. 子数组异或查询
 * 使用前缀和的思想
 * 求区间的异或和求区间的前缀和的思想差不多： xor(l,r)=xor(1,r)⊕xor(1,l−1)
 */
public class xorQueries {
    public static int[] xorQueries(int[] arr, int[][] queries){
        int len = arr.length;
        int lenQ = queries.length;
        int[] prefix = new int[len+1];
        prefix[0] = 0;
        for(int i = 0; i < len; i++){
            prefix[i+1] = prefix[i] ^ arr[i];
        }
        int[] result = new int[lenQ];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefix[right+1] ^ prefix[left];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(xorQueries(new int[]{16}, new int[][]{{0, 0}, {0, 0}}));
    }

}
