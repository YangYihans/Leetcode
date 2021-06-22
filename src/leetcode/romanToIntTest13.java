package leetcode;
/*
13.罗马数字转成整形
 */
public class romanToIntTest13 {
    public static void main(String[] args) {
        romanToIntTest13 t1 = new romanToIntTest13();
        String s = "XV";
        System.out.println(t1.romanToInt(s));
    }
    public int romanToInt(String s)
    {
        int res = 0;
        int n = s.length();
        int i = 0;
        while(i < n)
        {
            if(i <= n-2)
            {
                if(s.charAt(i) == 'I')
                {
                    if(s.charAt(i+1) == 'V')
                    {
                        res = res + 4;
                        i = i + 2;
                        continue;
                    }
                    else if(s.charAt(i+1) == 'X')
                    {
                        res = res + 9;
                        i = i + 2;
                        continue;
                    }
                    else
                        res = res + 1;
                }
                if(s.charAt(i) == 'X')
                {
                    if(s.charAt(i+1) == 'L')
                    {
                        res = res + 40;
                        i = i + 2;
                        continue;
                    }
                    else if(s.charAt(i+1) == 'C')
                    {
                        res = res + 90;
                        i = i + 2;
                        continue;
                    }
                    else
                        res = res + 10;
                }
                if(s.charAt(i) == 'C')
                {
                    if(s.charAt(i+1) == 'D')
                    {
                        res = res + 400;
                        i = i + 2;
                        continue;
                    }
                    else if(s.charAt(i+1) == 'M')
                    {
                        res = res + 900;
                        i = i + 2;
                        continue;
                    }
                    else
                        res = res + 100;
                }
                if(s.charAt(i) == 'V')
                    res = res + 5;
                if(s.charAt(i) == 'L')
                    res = res + 50;
                if(s.charAt(i) == 'D')
                    res = res + 500;
                if(s.charAt(i) == 'M')
                    res = res + 1000;
            }
            else
            {
                if(s.charAt(i) == 'I')
                    res = res + 1;
                if(s.charAt(i) == 'X')
                    res = res + 10;
                if(s.charAt(i) == 'C')
                    res = res + 100;
                if(s.charAt(i) == 'V')
                    res = res + 5;
                if(s.charAt(i) == 'L')
                    res = res + 50;
                if(s.charAt(i) == 'D')
                    res = res + 500;
                if(s.charAt(i) == 'M')
                    res = res + 1000;
            }
            i = i + 1;
        }
        return res;
    }
}
