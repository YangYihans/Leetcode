package leetcode.String;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 */
public class worldTrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            arrayList.add(sc.nextLine());
        }
        for(int i = 0; i < n; i++)
        {
            System.out.println(worldTrim(arrayList.get(i)));
        }
    }
    public static String worldTrim(String list)
    {
        if(list == null)
            return "";
        char[] chars = list.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for(int i = 1; i < len; i++)
        {
            if(chars[i] != chars[i-1])
            {
                sb.append(chars[i]);
                continue;
            }

            else if(i > 1 && chars[i] == chars[i-1] && chars[i-1] == chars[i-2])
            {
                continue;
            }

            else if(i > 2 && chars[i] == chars[i-1] && chars[i-2] == chars[i-3])
            {
                //chars[i] = '.';
                continue;
            }

            else
                sb.append(chars[i]);
        }
        return sb.toString();
    }
}
