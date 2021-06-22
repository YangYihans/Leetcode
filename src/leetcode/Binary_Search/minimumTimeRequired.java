package leetcode.Binary_Search;

import java.util.Arrays;

/**
 * @Author Yang
 * @Date 2021/5/8 10:24
 * @Description 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 */
//public class minimumTimeRequired {
//    public static int minimumTimeRequired(int[] jobs, int k) {
//        Arrays.sort(jobs);
//        int sum = getSum(jobs);
//        int left = (int)((double)sum / jobs.length), right = sum;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if(canFinish(jobs, mid, k)){
//                right = mid;
//            }else{
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//
//
//    private static int getSum(int[] jobs) {
//        int sum = 0;
//        for (int job : jobs) {
//            sum += job;
//        }
//        return sum;
//    }
//
//
//}
