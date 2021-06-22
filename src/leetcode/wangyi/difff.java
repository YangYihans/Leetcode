package leetcode.wangyi;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.HashMap;
import java.util.Scanner;

public class difff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] res = twoDiff(new int[]{2,4,5,6}, 1);
        System.out.println(res[0] + " " + res[1]);
    }
    public static int[] twoDiff(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int temp1 = target + nums[i];
            int temp2 = nums[i] - target;
            if(map.containsKey(temp1)){
                return new int[]{temp1, nums[i]};
            }
            if(map.containsKey(temp2)){
                return new int[]{temp2, nums[i]};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

