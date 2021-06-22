package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17.电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class letterCombinationsTest {
    private Map<Character,String> map;
    private List<String> result = new ArrayList<>();
    public static void main(String [] args)
    {
        letterCombinationsTest t1 = new letterCombinationsTest();
        String digits = "2345";
        System.out.println(t1.letterCombinations(digits));
    }
    public List<String> letterCombinations(String digits)
    {
        if(digits == null || digits.length() == 0)
            return result;
        map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghf");
        map.put('5',"jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        process("",0, digits);
        return result;
    }
    public void process(String x, int index, String digits)
    {
        if(index == digits.length())
        {
            result.add(x);
            return;
        }
        String s = map.get(digits.charAt(index));
        for(int i = 0; i < s.length(); i++)
        {
            process(x+s.charAt(i),index+1,digits);
        }
    }
}
