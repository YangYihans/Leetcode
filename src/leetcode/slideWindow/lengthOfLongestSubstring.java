package leetcode.slideWindow;

import java.util.HashMap;

/**
 * @Author Yang
 * @Date 2021/3/31 20:17
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        char[] s_char = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = Integer.MIN_VALUE;
        while(right < len){
            if(!map.containsKey(s_char[right])){
                map.put(s_char[right], 1);
                right++;
                continue;
            }
            while(map.containsKey(s_char[right])){
                if(right - left > maxLen){
                    maxLen = right - left;
                }
                map.remove(s_char[left]);
                left++;
            }

        }
        return Math.max(maxLen, right - left);   // right-left 是没有重复字段的情况
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
