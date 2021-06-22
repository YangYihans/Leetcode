package leetcode;

import java.util.Arrays;

/*
    力扣242.有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
    本题是49题的基础
 */
public class isAnagramTest242 {
    public static void main(String [] args)
    {
        isAnagramTest242 t1 = new isAnagramTest242();
        System.out.println(t1.isAnagram("rat","car"));
    }
    boolean isAnagram(String s, String t){
        if(s =="" && t =="")
            return true;
        if(s == "" || t =="")
            return false;
        if(s.length() != t.length())
            return false;
        char[] stochar = s.toCharArray();
        Arrays.sort(stochar);
        char[] ttochar = t.toCharArray();
        Arrays.sort(ttochar);
        for(int i = 0; i < s.length(); i++)
        {
            if(stochar[i] != ttochar[i])
                return false;
        }
        return true;
    }
}
