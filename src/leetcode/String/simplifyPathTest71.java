package leetcode.String;

import javax.sound.midi.SoundbankResource;
import java.util.Stack;

public class simplifyPathTest71 {
    public static void main(String[] args) {
        simplifyPathTest71 t1 = new simplifyPathTest71();
        System.out.println(t1.simplifyPath("/a/../../b/../c//.//"));
    }
    public String simplifyPath(String path)
    {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length; i++)
        {
            if(!stack.isEmpty() && s[i].equals(".."))
            {
                stack.pop();
            }
            else if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
            {
                stack.push(s[i]);
            }
        }
        if(stack.isEmpty())
            return "/";
        StringBuilder stringBuilder = new StringBuilder();
        //队列的方式来读取数据。
        for(int i = 0; i < stack.size(); i++)
        {
            stringBuilder.append("/");
            stringBuilder.append(stack.get(i));
        }
        return stringBuilder.toString();
    }
}
