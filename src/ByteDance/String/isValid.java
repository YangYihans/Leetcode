package ByteDance.String;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 */
public class isValid {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        if(s == " ")
            return true;
        if(s.length() == 1)
            return false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(!stack.isEmpty())
                {
                    if(stack.peek() == '(' && s.charAt(i) == ')')
                    {
                        stack.pop();
                    }
                    else if(stack.peek() == '{' && s.charAt(i) == '}')
                    {
                        stack.pop();
                    }
                    else if(stack.peek() == '[' && s.charAt(i) == ']')
                    {
                        stack.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        if(stack.isEmpty())
        {
            return true;
        }
        return false;
    }
}
