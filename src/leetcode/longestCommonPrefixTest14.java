package leetcode;
/*
14.最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
2020.2.13
 */
public class longestCommonPrefixTest14 {
    public static void main(String[] args) {
        longestCommonPrefixTest14 t1 = new longestCommonPrefixTest14();
        String [] strs = {"flower","foow","flight"};
        System.out.println(t1.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs)
    {
        String res = "";
        if(strs.length == 0)
            return res;
        res = strs[0];
        for(int i = 1; i < strs.length; i++)
        {
            int j = 0;
            for(; j < res.length()&&j < strs[i].length(); j++)
            {
                if(strs[i].charAt(j) != res.charAt(j))
                    break;
            }
            if(j < res.length())
            res = res.substring(0,j);

        }
        return res;
    }
}
