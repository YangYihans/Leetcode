package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    49.字母异位词分组
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
    [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
    ]
    说明：
        所有输入均为小写字母。
        不考虑答案输出的顺序。
    思路：构建hash表，对字母进行排序，对相同的进行比较，分别存在hash表中。
 */
public class groupAnagramsTest49 {
    public static void main(String [] args)
    {
        groupAnagramsTest49 t1 = new groupAnagramsTest49();
        String [] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(t1.groupAnagrams(strs));
    }
    List<List<String>> groupAnagrams(String [] strs)
    {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0 ;i < strs.length; i++)
        {
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String s = new String (a);
            if(hashMap.containsKey(s))
            {
                hashMap.get(s).add(strs[i]);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(s,list);
            }
        }
        for(String s : hashMap.keySet())
        {
            ans.add(hashMap.get(s));
        }
        return ans;
    }
}
