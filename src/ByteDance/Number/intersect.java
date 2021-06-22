package ByteDance.Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/**
 * @Author Yang
 * @Date 2021/3/26 11:05
 * @Description 350.两数组的交集II
 */
public class intersect {
    public int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int num : nums1){
            int i = map1.getOrDefault(num, 0) + 1;
            map1.put(num, i);
        }
        List<Integer>list = new ArrayList<>();
        for(int temp : nums2){
            int count = map1.getOrDefault(temp, 0);
            if(count > 0){
                list.add(temp);
                count--;
                if(count > 0){
                    map1.put(temp, count);
                }else{
                    map1.remove(temp);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
