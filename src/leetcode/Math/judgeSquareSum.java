package leetcode.Math;

import java.util.HashMap;

/**
 * @Author Yang
 * @Date 2021/4/28 9:12
 * @Description 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class judgeSquareSum {
    public static boolean judgeSquareSum(int c){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= Math.sqrt(c); i++){
            int target = c - i * i;
            if(map.containsValue(i * i) || c == 2 * i * i){
                return true;
            }
            map.put(i, target);
        }
        return false;
    }


    public static boolean judge(int c){
        int left = 0;
        int right = (int) Math.sqrt(c);
        while(left <= right){
            int target = left * left + right * right;
            if(target > c){
                right--;
            }else if(target < c){
                left++;
            }else{
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(judge(999999999));
    }
}
