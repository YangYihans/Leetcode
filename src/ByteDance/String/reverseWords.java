package ByteDance.String;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class reverseWords {
    public static void main(String[] args)
    {
        System.out.println(reverseWords("          je;;  dfs cva    "));
    }
    /*public static String reverseWords(String s)
    {
        s = s.trim();
        int len = s.length();
        if(len <= 0)
            return s;
        String[] strings = s.split(" ");
        String res = "";
        for(int j = strings.length-1; j >= 0; j--)
        {
            if(strings[j].length() == 0)
                continue;
            if(j != 0)
            {
                res += strings[j] + " ";
            }
            if(j == 0)
            {
                res += strings[j];
            }
        }
        return res;
    }*/
    public static String reverseWords(String s)
    {
        s = s.trim();
        int len = s.length()-1;
        int i = 0,j = 0;
        StringBuilder sb = new StringBuilder();
        while(j <= len)
        {
            while(j <= len && s.charAt(j) != ' ')
            {
                j++;
            }
            sb.append(s.substring(i,j) + " ");
            while(j <= len && s.charAt(j) == ' ')
            {
                j++;
            }
            i = j;
        }
        return  sb.toString().trim();
    }
}
