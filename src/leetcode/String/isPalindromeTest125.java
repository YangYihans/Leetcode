package leetcode.String;



/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class isPalindromeTest125 {
    public static void main(String[] args) {
        isPalindromeTest125 t1 = new isPalindromeTest125();
        System.out.println(t1.isPalindrome("race a car"));
    }
    public boolean isPalindrome(String s)
    {
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        char[] chars = s.toCharArray(); //转换为小写
        int i = 0;
        int j = chars.length-1;
        while (i < j)
        {
            if((chars[i]>='a'&& chars[i] <='z') || (chars[i] >= '0' && chars[i] <= '9')) //a-z 0-9
            {
                if((chars[j]>='a'&& chars[j] <='z') || (chars[j] >= '0' && chars[j] <= '9'))
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
                else
                {
                    j--;
                    continue;
                }

            } //other
            else
                i++;
        }
        return true;
    }
}
