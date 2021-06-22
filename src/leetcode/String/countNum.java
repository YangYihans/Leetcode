package leetcode.String;

import java.util.Scanner;

/*
通过键盘输入一串小写字母(a~z)组成的字符串。
请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
例如字符串"babcc"归一化后为"a1b2c2"
 */
public class countNum {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(countNum(input));
    }
    public static String countNum(String input)
    {
        if(input.length() == 0)
            return "";
        char[] chars = input.toCharArray();
        int[] nums = new int[26];
        for(int i = 0; i < chars.length; i++)
        {
            nums[chars[i]-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                continue;
            else
            {
                char x = (char) ('a'+i);
                sb.append(x);
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }
}
