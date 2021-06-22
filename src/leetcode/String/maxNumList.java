package leetcode.String;
/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 */

import java.util.Scanner;

public class maxNumList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        System.out.println(maxNumList(list));
    }
    public static String maxNumList(String list)
    {
        if(list.length() == 0)
            return "";
        char[] chars = list.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < chars.length; i++)
        {
            if(chars[i]>='0' && chars[i]<='9')
            {
                count++;
                sb.append(chars[i]);
            }
            else
            {
                if(count > maxCount)
                {
                    sb.replace(0, maxCount, "");
                    maxCount = count;
                }
                else
                {
                    sb.replace(maxCount,maxCount+count, "");
                }
                count = 0;
            }
            if(i == chars.length - 1)
            {
                if(count > maxCount)
                {
                    sb.replace(0, maxCount, "");
                    maxCount = count;
                }
                else
                {
                    sb.replace(maxCount,maxCount+count, "");
                }
            }
        }
        return sb.toString();
    }
}
