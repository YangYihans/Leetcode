package leetcode.greedy.interval;
import com.sun.javafx.scene.control.behavior.SliderBehavior;

import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/10 11:11
 * @Description 57. 插入区间
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        if(newInterval == null || newInterval.length == 0){
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for(int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[1] < start || interval[0] > end){ // 如果当前区间的end < 待插入区间的start || 当前区间的start > 待插入区间的end 说明两个区间是没有交集的
                list.add(new int[]{interval[0], interval[1]});
            }
            else{  // 有交集的情况， 直接更新相交区间的start和end
                start = Math.min(interval[0], start);
                end = Math.max(interval[1], end);
            }
        }
        list.add(new int[]{start, end});
        int[][] res = list.toArray(new int[0][]);  // 将list<int[]> 转化为二维数组。
        Arrays.sort(res, new Comparator<int[]>() {  // 对得到的结果按照起始位置进行排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return res;
    }

    public static void main(String[] args) {
        insert(new int[][]{}, new int[]{4,8});
    }
}
