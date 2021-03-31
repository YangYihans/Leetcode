package leetcode.slideWindow;
/**
 * @Author Yang
 * @Date 2021/3/31 19:35
 * @Description 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
public class checkInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        int s1_len = s1.length();
        int s2_len = s2.length();
        if(s2_len < s1_len){
            return false;
        }
        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();
        int[] freq = new int[126];
        int[] window = new int[126];
        for(char i : s1_char){
            freq[i]++;
        }
        int distance = 0;
        int left = 0, right = 0;
        while(right < s2_len){
            if(freq[s2_char[right]] == 0){
                right++;
                continue;
            }
            if(window[s2_char[right]] < freq[s2_char[right]]){
                distance++;
            }
            window[s2_char[right]]++;
            right++;
            while(distance == s1_len){
                if(right - left == s1_len){
                    return true;
                }
                if(freq[s2_char[left]] == 0){
                    left++;
                    continue;
                }
                if(freq[s2_char[left]] == window[s2_char[left]]){
                    distance--;
                }
                window[s2_char[left]]--;
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
