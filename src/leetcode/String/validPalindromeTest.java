package leetcode.String;


import javax.sound.midi.SoundbankResource;

/**
 * 验证回文字符串II
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class validPalindromeTest {
    public static void main(String[] args) {
        validPalindromeTest t1 = new validPalindromeTest();
        System.out.println(t1.validPalindrome("abda"));
    }
    public boolean validPalindrome(String s)
    {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        int countFlag = 0;
        while(i < j)
        {
            if(chars[i] == chars[j])
            {
                i++;
                j--;
                continue;
            }
            if(chars[i] != chars[j] && countFlag == 0) //diyici
            {
                if(i + 1 == j)
                    return true;
                else if(chars[i] == chars[j-1] && chars[i+1] != chars[j])
                {
                    countFlag = 1;
                    i++;
                    j = j-2;
                    continue;
                }
                else if(chars[i+1] == chars[j] && chars[i] != chars[j-1])
                {
                    countFlag = 1;
                    j--;
                    i = i+2;
                    continue;
                }
                else if(chars[i] == chars[j-1] && chars[i+1] == chars[j]) //最开始没有考虑到这种情况
                {
                    boolean flag1 = search(i+1,j-2,chars);
                    if(flag1 == true)
                        return true;
                    boolean flag2 = search(i+2, j-1,chars);
                    if(flag2 == true)
                        return true;
                    return false;
                }
                else
                    return false;
            }
            if(chars[i] != chars[j] && countFlag == 1)
                return false;
        }
        return true;
    }
    public boolean search(int i, int j, char[] chars)
    {
        while(i < j)
        {
            if(chars[i] == chars[j])
            {
                i++;
                j--;
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
