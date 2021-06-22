package ByteDance.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(4);
        for(String s : res)
        {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n)
    {
        List<String> res = new ArrayList<>();
        if(n == 0)
            return res;
        backTrack("", n, n, res);
        return res;

    }
    public static void backTrack(String s, int left, int right, List<String> res)
    {
        if(left == 0 && right == 0)
        {
            res.add(s);
            return;
        }
        if(left > right)
        {
            return;
        }
        if(left > 0)
        {
            backTrack(s+"(", left-1,right,res);
        }
        if(right > 0)
        {
            backTrack(s+")", left, right-1, res);
        }

    }
}
