package leetcode.Back_Trace;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Yang
 * @Date 2021/4/16 15:44
 * @Description 87. 扰乱字符串
 * 判断字符串II是不是字符串I的扰乱字符串
 */
public class isScramble {
    static HashSet<String> visited = new HashSet<>();
    public static boolean isScramble(String s1, String s2) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();
        // 判断长度是否相等
        if(len_s1 != len_s2){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        if(visited.contains(s1+"-"+s2))//减枝
            return false;
        visited.add(s1+"-"+s2);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars_s1 = s1.toCharArray();
        char[] chars_s2 = s2.toCharArray();
        // 判断词频是否相等
        for(int i = 0; i < len_s1; i++){
            int j = map.getOrDefault(chars_s1[i], 0) + 1;
            map.put(chars_s1[i], j);
            int k = map.getOrDefault(chars_s2[i], 0) - 1;
            map.put(chars_s2[i], k);
        }
        for(Character key : map.keySet()){
            if(map.get(key) != 0 ){
                return false;
            }
        }
        for(int i = 1; i < len_s1; i++){
            boolean flag = (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0,i), s2.substring(len_s1 - i)) && isScramble(s1.substring(i), s2.substring(0, len_s1 - i)));
            if(flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
    }
}
