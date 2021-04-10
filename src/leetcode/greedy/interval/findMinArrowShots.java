package leetcode.greedy.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Yang
 * @Date 2021/4/9 16:46
 * @Description 452. 用最少数量的箭引爆气球
 * 本质上是找有多少个重合的区间
 */
public class findMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        int count = 1;
        int end = points[0][1];
        for(int[] point : points){
            if(point[0] > end){
                count++;
                end = point[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
