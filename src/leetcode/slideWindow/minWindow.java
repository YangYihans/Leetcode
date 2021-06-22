package leetcode.slideWindow;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Yang
 * @Date 2021/3/31 17:14
 * @Description 76.最小覆盖子串
 * 模板
 */
public class minWindow {
    public static String minWindow(String s, String t){
        int s_len = s.length();
        int t_len = t.length();
        if(s_len == 0 || t_len == 0 || s_len < t_len){
            return "";
        }

        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int[] freq = new int[128];  // 子串t中元素出现的频率
        int[] window = new int[128];
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int distance = 0;          //  有用的子串的长度
        for(char i : t_char){      //  统计子串的字符出现频率
            freq[i]++;
        }
        int left = 0, right = 0;
        while(right < s_len){
            /**
             * 右指针右移过程
             */
            if(freq[s_char[right]] == 0){  // 子串中没有出现直接跳过
                right++;
                continue;
            }
            if(window[s_char[right]] < freq[s_char[right]]){  // 子串中出现， 在窗口统计中添加， 符和子串的长度增加
                distance++;
            }
            window[s_char[right]]++;
            right++;
            /**
             * 左指针是否要收缩
             */
            while(distance == t_len){
                // 条件判断
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                if(freq[s_char[left]] == 0){
                    left++;
                    continue;
                }
                if(freq[s_char[left]] == window[s_char[left]]){
                    distance--;
                }
                window[s_char[left]]--;
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start+minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "c"));


    }
}
