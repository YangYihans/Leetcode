package leetcode.bitOperation;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 异或的性质：
 * a ^ a = 0   ----- 任何数和自己异或的结果是0
 * a ^ 0 = a   ----- 任何数和0异或是它本身
 * a ^ b = b ^ a  -----
 * a ^ b ^ a = a ^ a ^ b = b
 * 异或运算满足交换律和结合律
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
