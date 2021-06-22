package leetcode.String;

import java.util.*;
/*
字符串匹配问题 字符串的子串问题
 */
public class stringMatchingTest {
    public static void main(String[] args) {
        stringMatchingTest t1 = new stringMatchingTest();
        String[] words = new String[]{"o","mass","as","hero","superhero"};
        System.out.println(t1.stringMatching(words));
     }
    public List<String> stringMatching(String[] words)
    {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(words,((o1, o2) -> o1.length()-o2.length()));
        for(int i = 0; i < words.length-1; i++)
        {
            for(int j = i+1; j < words.length; j++)
            {
                if(words[j].contains(words[i]))
                {
                    set.add(words[i]);
                }
            }
        }
        for(String s : set)
        {
            list.add(s);
        }
        return list;
    }

}
