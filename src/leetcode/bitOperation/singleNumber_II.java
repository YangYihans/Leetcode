package leetcode.bitOperation;

import java.util.HashMap;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class singleNumber_II {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int x : map.keySet()){
            if(map.get(x) == 1){
                return x;
            }
        }
        return -1;
    }

    public int singleNumber_II(int[] nums){
        int one = 0;
        int two = 0;
        for(int x : nums){
            one = one ^ x & ~two;
            two = two ^ x & ~one;
        }
        return one;
    }

}
