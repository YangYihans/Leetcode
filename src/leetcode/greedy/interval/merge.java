package leetcode.greedy.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

/**
 * @Author Yang
 * @Date 2021/4/9 16:55
 * @Description 56. 合并区间
 * 合并区间需要返回合并后的区间，所以按照起始位置的大小进行排序。而不是按照末端进行排序
 */
public class merge {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < len; i++){
            int[] interval = intervals[i];
            if(interval[0] <= end){
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }else{
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {8, 9}, {11, 15}});
    }


}
