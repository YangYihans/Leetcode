package leetcode;

import java.util.Stack;

public class reformatTest {
    public static void main(String[] args) {
        reformatTest t1 = new reformatTest();
        String s = "aa";
        System.out.println(t1.reformat(s));
    }
    public String reformat(String s)
    {
        int len  = s.length();
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        char[] chars = s.toCharArray();
        int k = 0;
        int l = 0;
        for (int i = 0; i < len; i++)
        {
            if(chars[i] >='0' && chars[i] <= '9')
            {
                stack1.push(chars[i]);
                k++;
            }

            else
            {
                stack2.push(chars[i]);
                l++;
            }

        }
        while(!stack1.isEmpty())
        {
            stack3.push(stack1.pop());
        }
        while(!stack2.isEmpty())
        {
            stack4.push(stack2.pop());
        }
        if((k == 0&&l>=2) || (l == 0&&k>=2) || Math.abs(k-l)>=2)
            return "";
        String res = "";
        if(k == 1 && l ==0)
        {
            res += stack3.pop();
            return res;
        }
        if(k == 0 && l ==1)
        {
            res += stack4.pop();
            return res;
        }
        if(k >= l)
        {
            while(!stack4.isEmpty())
            {
                res += stack3.pop();
                res += stack4.pop();
            }
            if(!stack3.isEmpty())
            res += stack3.pop();
        }
        else
        {
            while(!stack3.isEmpty())
            {
                res += stack4.pop();
                res += stack3.pop();
            }
            if(!stack4.isEmpty())
            res += stack4.pop();
        }
        return res;
    }
}

