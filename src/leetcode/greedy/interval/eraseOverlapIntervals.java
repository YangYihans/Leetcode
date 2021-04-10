package leetcode.greedy.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Yang
 * @Date 2021/4/9 16:39
 * @Description 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 思路：末端对其，找到相交的点， 每次比较的是末端和下一段的起点，如果不相交就将末端重新赋值为当前段的末端，否则就不进行操作。
 */
public class eraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals){
        int len = intervals.length;
        if(len == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for(int[] interval : intervals){
            if(interval[0] >= end){
                count++;
                end = interval[1];
            }
        }
        return len - count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    }
}
