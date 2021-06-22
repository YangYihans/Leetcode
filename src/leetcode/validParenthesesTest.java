package leetcode;

import java.util.Stack;

/*
  力扣20.有效的括号
  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
  有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
  注意空字符串可被认为是有效字符串。
  需要注意：只有右括号的情况和所有的右括号全部匹配但是左括号有剩余的情况。
 */
public class validParenthesesTest {
    public static void main(String [] args)
    {
        validParenthesesTest t1 = new validParenthesesTest();
        System.out.println(t1.isValid("]]]]"));
    }
    boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        if(s == "")
            return true;
        if(s.length() == 1) //对于只有一个符号的情况的判断
            return false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(!stack.empty())
                {
                    if(s.charAt(i) == ')' && stack.peek() == '(')
                    {
                        stack.pop();
                        continue;
                    }
                    if(s.charAt(i) == ']' && stack.peek() == '[')
                    {
                        stack.pop();
                        continue;
                    }
                    if(s.charAt(i) == '}' && stack.peek() == '{')
                    {
                        stack.pop();
                        continue;
                    }
                    else
                        return false; //括号不匹配直接弹出
                }
                else
                    return false;//直接输入右括号的情况
            }
        }
        if(stack.empty()) //判断是否在栈中有剩余的未被匹配的左括号
        {
            return true;
        }
        return false;
    }
}
