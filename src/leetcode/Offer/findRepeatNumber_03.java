package leetcode.Offer;

import java.util.HashMap;

/**
 * @Author Yang
 * @Date 2021/4/29 16:44
 * @Description 剑指 Offer 03. 数组中重复的数字
 * 请找出数组中任意一个重复的数字。
 */
public class findRepeatNumber_03 {
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return num;
            }
            map.put(num, 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
    }
}
