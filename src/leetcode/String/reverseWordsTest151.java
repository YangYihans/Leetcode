package leetcode.String;

import java.util.Stack;

public class reverseWordsTest151 {
    public static void main(String[] args) {
        reverseWordsTest151 t1 = new reverseWordsTest151();
        String s = "  a good   example  ";
        System.out.println(t1.reverseWords(s));
    }
    public String reverseWords(String s)
    {
        s = s.trim();
        int len = s.length();
        Stack stack = new Stack();
        if(len == 0)
            return "";
        if(len == 1)
            return s;
        int i = len - 1;
        String res = "";
        int spaceNum = 0;
        char[] chars = s.toCharArray();
       /* while(chars[i] == ' ')
        {
            i--;
        }*/
        for(; i >= 0; i--)
        {
            if(chars[i] != ' ')
            {
                spaceNum = 0;
                stack.push(chars[i]);
                continue;
            }

            if(chars[i] == ' ' && spaceNum == 0)
            {
                while(!stack.isEmpty())
                {
                    res = res + stack.pop();
                }
                res = res + ' ';
                spaceNum++;
                continue;
            }
            if(chars[i] == ' '&& spaceNum != 0)
            {
                continue;
            }
        }
        while(!stack.isEmpty())
        {
            res = res + stack.pop();
        }
        return res;
    }

}
