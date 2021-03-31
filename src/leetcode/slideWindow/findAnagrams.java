package leetcode.slideWindow;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/3/31 20:01
 * @Description 438. 找到字符串中所有字母异位词
 *
 */
public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        if(s_len < p_len){
            return new ArrayList<Integer>();
        }
        char[] s_char = s.toCharArray();
        char[] p_char = p.toCharArray();
        int[] freq = new int[126];
        int[] window = new int[126];
        for(char i : p_char){
            freq[i]++;
        }
        int left = 0, right = 0, distance = 0;
        List<Integer> res = new ArrayList<>();
        while(right < s_len){
            if(freq[s_char[right]] == 0){
                right++;
                continue;
            }
            if(window[s_char[right]] < freq[s_char[right]]){
                distance++;
            }
            window[s_char[right]]++;
            right++;
            while(distance == p_len){
                if(right - left == p_len){
                    res.add(left);
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
        return res;
    }
}
