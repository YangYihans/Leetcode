package leetcode;

public class gcdOfStringsTest1071 {
    public static void main(String[] args) {
        gcdOfStringsTest1071 t1= new gcdOfStringsTest1071();
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.print(t1.gcdOfStrings(str1,str2));
    }

    /**
     * 暴力解法：前缀串的长度必须是两个字符串长度的约数才能满足条件，否则无法经过若干次拼接后得到长度相等的字符串。
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int len = Math.min(n,m);
        String res = "";
        if(n == 0 || m == 0)
            return res;
        for(int i = len; i > 0; i--)
        {
            if(n % i == 0 && m % i == 0)
            {
                String temp = str1.substring(0,i);
                if(check(str1,temp) && check(str2,temp))
                    return temp;
            }
        }
        return res;
    }

    /**
     * 根据现在子串的长度计算需要重复的次数，然后比较循环对应次数后是否和待比较的原串相同。
     * @param str1
     * @param str2
     * @return
     */
    boolean check(String str1, String str2)
    {
        int times = str1.length()/str2.length();
        String ans = "";
        for(int i = 0; i < times; i++)
        {
            ans = ans + str2;
        }
        return ans.equals(str1);
    }

}
