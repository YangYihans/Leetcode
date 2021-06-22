package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
力扣面试题57-II 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

返回值为二维数组问题可以转换为 List<int[]> list = new ArrayList<>(); list.toArray(new int[0][]);
 */
public class findContinuousSequenceTest {
    public static void main(String[] args) {
        firstMissingPositiveTest t1 = new firstMissingPositiveTest();
    }
    public int[][] findContinuousSequence(int target)
    {
        List<int[]> list = new ArrayList<>();
        int l = 1;
        int r = 2;
        int sum = l + r;
        while (l < r && r < target)
        {
            if(sum < target)
            {
                r = r + 1;
                sum = sum + r;
            }
            else if(sum > target)
            {
                sum = sum - l;
                l++;
            }
            else
            {
                int[] temp = new int[l-r+1];
                int k = 0;
                for(int i = l; i <= r; i++)
                {
                    temp[k++] = i;
                }
                list.add(temp);
                l++;
                r = l + 1;
                sum = l + r;
            }
        }

        return list.toArray(new int[0][]);
    }
}
