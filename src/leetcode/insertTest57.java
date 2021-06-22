package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class insertTest57 {
    public static void main(String[] args) {
        insertTest57 t1 = new insertTest57();
        int[][] intervals = new int[][]{{1,3}};
        int[] a = new int[]{2,5};
        int [][] res = t1.insert(intervals,a);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println("{"+res[i][0]+","+res[i][1]+"}");
        }
    }
    public int[][] insert(int [][] intervals, int[] newInterval)
    {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        int flag = 0;
        //for(int i = 0; i < n; i++)
        int i = 0;
        while(i < n)
        {
            if(intervals[i][1] < newInterval[0])
            {
                list.add(new int[]{intervals[i][0],intervals[i][1]});
                i++;
                continue;
            }
            if(intervals[i][0] > newInterval[1])
            {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
                continue;
            }
            int[] temp = new int[]{newInterval[0], newInterval[1]};
            while(i < n &&newInterval[1] >= intervals[i][0])
            {
                flag = 1;
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                i++;
            }
            list.add(new int[]{temp[0],temp[1]});
        }
        if(flag == 0)
            list.add(new int[]{newInterval[0],newInterval[1]});
        int [][] res = (int [][]) list.toArray(new int[list.size()][2]);
        Arrays.sort(res,(o1, o2) -> o1[0]- o2[0]);
        return res;
    }
}
