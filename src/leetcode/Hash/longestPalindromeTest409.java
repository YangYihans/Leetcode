package leetcode.Hash;
/*
力扣409：最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class longestPalindromeTest409 {
    public static void main(String[] args) {
        longestPalindromeTest409 t1 = new longestPalindromeTest409();
        String s = "cccaa";
        System.out.println(t1.longestPalindrome(s));
    }
    public int longestPalindrome(String s)
    {
        int n = s.length();
        if(n == 0)
            return 0;
        int res = 0;
        int flag = 0;
        int [] array = new int [52];
        for(int i = 0; i < n; i++) //统计各个字符出现的次数
        {
            char temp = s.charAt(i);
            if(temp >='a' && temp <= 'z')
            {
                array[temp - 'a'] ++;
            }
            if(temp >= 'A' && temp <= 'Z')
            {
                array[temp - 'A' + 26]++;
            }
        }
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] % 2 == 0)
            {
                res = res + array[i];
            }
            if(array[i] % 2 !=0 && array[i] > 1)
            {
                res  = res + array[i] - 1;
                flag = 1;
            }
            if(array[i] == 1)
            {
                flag ++;
            }
        }
        if(flag == 0) //所有的字母均成对的情况
            return res;
        return res+1;
    }
}
