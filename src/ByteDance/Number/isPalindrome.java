package ByteDance.Number;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class isPalindrome {
    public boolean isPalindrome(int x)
    {
        if(x < 0)
            return false;
        String res = String.valueOf(x);
        int l = 0;
        int r = res.length();
        char[] chars = res.toCharArray();
        while (l < r)
        {
            if(chars[l] == chars[r])
            {
                l++;
                r--;
                continue;
            }
            else
                return false;

        }
        return true;

    }

}
