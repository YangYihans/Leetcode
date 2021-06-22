package leetcode.String;

import java.util.*;

/*
  力扣第三题
  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class lengthOfLongestSubstringTest {
    public static void main(String[] args)
    {
        lengthOfLongestSubstringTest test = new lengthOfLongestSubstringTest();
        System.out.println(test.lengthOfLongestSubstring("absdqfdjkjqwre31wrcafsbcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        int max = 1;
        int j = 1;
        int k = 0;
        if (s.length() == 0 || s == " ")
            return 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                map1.put(s.charAt(0), 1);
            }
            else {
                if (map1.containsKey(s.charAt(i))&& k < map1.get(s.charAt(i)))
                {
                    k = map1.get(s.charAt(i));
                    System.out.println("-------");
                    System.out.println("k: "+k);
                    j =i - k+1; //如果遇到重复的，判断重复字符之间的长度，重新计数，相当于对重复之前内容的舍弃。
                    map1.remove(s.charAt(i));
                    System.out.println("remove");
                    map1.put(s.charAt(i), i+1); //将原来存在的清空，将后一次出现的存入Map中。
                }
                else
                {
                    j++;
                    map1.put(s.charAt(i), i+1);
                }

            }
            if(max <= j)
                max = j;
            System.out.println("j:"+j);
            System.out.println("max:"+max);
        }
        return max;
    }
}
