package ByteDance.String;

/**
 * 最长回文子串
 */
public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s)
    {
        int len = s.length();
        if(len < 2)
            return s;
        int maxLen = 1;
        String res = s.substring(0,1);
        for(int i = 0; i < len-1; i++)
        {
            String oddStr = centerSpread(s,i,i);
            String evenStr = centerSpread(s,i,i+1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if(maxLenStr.length() > maxLen)
            {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        //left = right，此时回文中心是一个字符，回文串的长度是奇数。
        //right = left+1， 此时回文中心是一个空隙，回文串的长度是偶数。
        int len = s.length();
        int i = left;
        int j = right;
        while(i >= 0 && j < len)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i--;
                j++;
            }
            else
                break;
        }
        return s.substring(i+1, j);
    }

}
