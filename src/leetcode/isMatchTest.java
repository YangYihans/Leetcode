package leetcode;
/*
44.通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *
"abefcdgiescdfimde"
"ab*cd?i*de"
"leetcode"
"*e*t?d*"
"mississippi"
"m??*ss*?i*pi"
*/
public class isMatchTest {
    public static void main(String[] args) {
        isMatchTest t1 = new isMatchTest();
        System.out.println(t1.isMatch("mississippi","m??*ss*?i*pi"));
    }
    public boolean isMatch(String s, String p)
    {
        if(s.length() == 0)
        {
            if(p.length()==0)
                return true;
            if(p.length()==1 && p.contains("*"))
                return true;
            else
                return false;
        }
        if(p.length() == 0)
        {
            if(s.length() == 0)
                return true;
            else
                return false;
        }
        if(s.length()!=p.length() && !(p.contains("*")))
            return false;
        if(s.length()<p.length()&&!p.contains("*"))
            return false;
        else
        {
            int i = 0;
            int j = 0;
            char temp = ' ';
            while(i<s.length()&&j<p.length())
            {
                if(s.charAt(i) == p.charAt(j))
                {
                    i++;
                    j++;
                    continue;
                }
                else
                {
                    if(p.charAt(j) == '?')
                    {
                        i++;
                        j++;
                        continue;
                    }
                    if(p.charAt(j) == '*' && j < p.length()-1)
                    {
                        if(p.charAt(j+1) != '*')
                        {

                            int k =s.indexOf(p.charAt(j+1));
                            if(i <= k)
                                i = k;
                            else {
                                s = s.substring(i,s.length());
                                k = s.indexOf(p.charAt(j+1));
                            }
                            boolean flag = false;
                            //s = s.substring(k,s.length());
                            p = p.substring(j+1,p.length());
                            while(k<s.length())
                            {
                                s = s.substring(k,s.length());
                                flag = isMatch(s,p);
                                if(flag == true)
                                    return true;
                                if(s.length()<p.length())
                                    return false;
                                else
                                {
                                   // s = s.replace(s.charAt(0),'#');
                                    s = s.substring(1,s.length());

                                    k = s.indexOf(p.charAt(0));
                                    if(k == -1)
                                        return false;
                                }
                            }
                            return false;
                        }
                        if(p.charAt(j+1) == '*')
                        {
                            i++;
                            j++;
                            continue;
                        }
                    }
                    if(p.charAt(j) == '*' && j == p.length()-1)
                        return true;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
