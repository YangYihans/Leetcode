package leetcode;
/*
58.最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
示例：
输入: "Hello World"
输出: 5
 */
public class lengthOfLastWord58 {
    public static void main(String[] args) {
        lengthOfLastWord58 t1 = new lengthOfLastWord58();
        System.out.println(t1.lengthOfLastWord("a "));
    }
    public int lengthOfLastWord(String s)
    {
        if(s.length() == 0)
            return 0;
        int count = 0;
        s= s.trim();
        for(int i = s.length()-1 ; i >= 0; i--)
        {
            if(s.charAt(i) != ' ')
            {
                count++;
                continue;
            }
            else
                break;
        }
        return count;
    }
}

