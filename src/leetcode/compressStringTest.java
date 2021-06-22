package leetcode;

public class compressStringTest {
    public static void main(String[] args) {
        compressStringTest t1 = new compressStringTest();
        String s = "abbccd";
        System.out.print(t1.compressString(s));
    }
    public String compressString(String S)
    {
        int n = S.length();
        int cnt = 1;
        String res = "";
        if(n == 0)
            return res;
        for(int i = 0; i < n-1; i++)
        {
            if(i < n-2)
            {
                if(S.charAt(i) == S.charAt(i+1))
                {
                    cnt++;
                }
                else
                {
                    res = res + S.charAt(i) + cnt;
                    cnt = 1;
                }
            }
            if( i == n-2)
            {
                if(S.charAt(i) == S.charAt(i+1))
                {
                    cnt ++;
                    res = res + S.charAt(i) + cnt;
                }
                else
                {
                    res = res + S.charAt(i) + cnt;
                    cnt = 1;
                    res = res + S.charAt(i+1) + cnt;
                }
            }
        }
        if(res.length() < n)
            return res;
        return S;
    }

}
