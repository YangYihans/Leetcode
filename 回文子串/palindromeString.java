public class palindromeString {
    /**
     * @Author Yang
     * @Date 2020/11/29 12:09
     * @Description 回文子串
     * 给定一个字符串，统计这个字符串中回文串的个数。
     * 使用的是中心扩展的方法。
     * 中心的选择： 中心有两种，一种是单中心，对应的回文串是奇数的情况， 一种是双中心，对应的回文串是偶数的情况。
     * 这两种中心就可以组成所有的中心情况。
     * 这两种中心的个数分别是 len（单） + len - 1 （双） = 2 * len - 1；
     * left、right分别对应的是左右两个指针，奇数的时候初始指向的是相同位置， 偶数的时候指向的是不同的位置。
     * 然后向左右两侧开始遍历即可。
     * 本题是统计回文串的个数，所以只要有符合条件的，result++。
     */
    public int countSubstrings(String s){
        if(s == null)
            return 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for(int center = 0; center < s.length() * 2 - 1; center++){
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < s.length() && chars[left] == chars[right]){
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 12:21
     * @Description 最长回文子串
     * 和上一题是相同类型的。
     *
     */
    public static String longestPalindrome(String s){
        if(s == null)
            return "";
        String result = "";
        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for(int center = 0; center < 2 * chars.length - 1; center++){
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < chars.length && chars[left] == chars[right]){
                left--;
                right++;
            }
            int len = right - left - 1;
            if(len > result.length()){
                result = s.substring(left+1, right);
            }
        }
        return result;
    }
}
