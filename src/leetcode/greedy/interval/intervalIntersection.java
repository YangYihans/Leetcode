package leetcode.greedy.interval;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/10 11:38
 * @Description 986. 区间列表的交集
 * 求两个闭区间的交集
 * 每个区间列表都是成对 不相交 的，并且 已经排序 。
 */
public class intervalIntersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0){
            return new int[][]{};
        }
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            int left = Math.max(firstList[i][0], secondList[j][0]);  // 左边界 两个的最大值
            int right = Math.min(firstList[i][1], secondList[j][1]); // 右边界 两个的最小值
            if(left <= right){  // 存在交集
                list.add(new int[]{left, right});
            }
            if(firstList[i][1] < secondList[j][1]){  // 哪个右边小就移动到下一个数组
                i++;
            }else{
                j++;
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        intervalIntersection(new int[][]{{0,2},{5,10}, {13,23}, {24,25}}, new int[][]{{1,5}, {8,12}, {15,24}, {25,26}});
    }
}
