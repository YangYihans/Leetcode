package ByteDance.String;

import java.util.Stack;

public class simplifyPath {
    public static void main(String[] args)
    {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }
    public static String simplifyPath(String path)
    {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < strings.length; i++)
        {
            if(!stack.isEmpty() && strings[i].equals(".."))
            {
                stack.pop();
            }
            else if(!strings[i].equals("") && !strings[i].equals(".") && !strings[i].equals(".."))
                stack.push(strings[i]);
        }
        if(stack.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++)
        {
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
