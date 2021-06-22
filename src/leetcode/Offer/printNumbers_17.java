package leetcode.Offer;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/5/23 10:16
 * @Description 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class printNumbers_17 {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= end - 1; i++){
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
