package leetcode.Math;
/**
 * @Author Yang
 * @Date 2021/5/11 9:18
 * @Description 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 */
public class decode {
        public int[] decode(int[] encoded) {
            int len=encoded.length;
            int[] perm=new int[len+1];

            int total_perm=0;//求perm数组的所有元素异或值
            for(int i=1;i<=len+1;i++){
                total_perm=total_perm^i;
            }

            int toatl_encoded=0;//求encoded数组中除了perm[0]以外的异或值
            for(int i=1;i<len;i+=2){
                toatl_encoded=toatl_encoded^encoded[i];
            }

            int start=total_perm^toatl_encoded;
            perm[0]=start;//和本月5号原题一模一样思路倒推原来的perm数组
            for(int i=1;i<len+1;i++){
                perm[i]=perm[i-1]^encoded[i-1];
            }
            return perm;
        }
}
