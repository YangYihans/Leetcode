package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class findContinuesSequence {
    public static void main(String[] args) {
        int target = 9;
        findContinuesSequence(9);
    }
    public static int[][] findContinuesSequence(int target)
    {
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        while(i <= target/2) //i + i + 1 > target
        {
            if(sum < target)
            {
                sum += i;
                j++;
            }
            else if(sum > target)
            {
                sum -= i;
                i++;
            }
            else
            {
                int[] temp = new int[j-i];
                for(int z = i; z <= j; z++)
                {
                    temp[z-i] = z;
                }
                res.add(temp);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
