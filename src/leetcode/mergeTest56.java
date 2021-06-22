package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
力扣56：合并区间
给出一个区间集合，请合并出所有的重叠区间。
注意：二维数组的lanbda表达式和list转换为二维数组的方法。
 */
public class mergeTest56 {
    public static void main(String[] args) {
        mergeTest56 t1 = new mergeTest56();
        int[][] interval = new int[][]{{1,3},{2,6},{5,18},{10,21}};
        int[][] res = t1.merge(interval);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println("{"+res[i][0]+","+res[i][1]+"}");
        }
    }

    /**
     * 二维数组排序的lanbemda表达式
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals)
    {
        int n = intervals.length;
        if(n == 0)
            return intervals;
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        int i = 0;
        int j = 0;
        int left = 0;
        int right = 0;
        int flag = 0;
        while(i < n-1)
        {
            if(intervals[i][1] < intervals[i+1][0])
            {
                left = intervals[i][0];
                right = intervals[i][1];
                list.add(new int[]{left,right});
                i++;
                if(i == n-1)
                {
                    left = intervals[i][0];
                    right = intervals[i][1];
                    list.add(new int[]{left,right});
                    break;
                }
                continue;
            }

            while(i < n-1 &&intervals[i][1]>=intervals[i+1][0])
            {
                int k = Math.max(intervals[i][1],intervals[i+1][1]);
                left = intervals[i][0];
                right = k;
               // list.add(new int[]{left, right});
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = k;
                i = i + 1;
            }
            list.add(new int[]{left,right});
            i++;
            if(i == n-1)
            {
                left = intervals[i][0];
                right = intervals[i][1];
                list.add(new int[]{left,right});
                break;
            }
        }
        int [][] res = (int [][]) list.toArray(new int[list.size()][2]);
        return res;
    }
}
