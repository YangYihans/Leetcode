package leetcode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesisTest22 {
    public static void main(String[] args) {
        generateParenthesisTest22 t1 = new generateParenthesisTest22();
        System.out.println(t1.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n)
    {
        List<String> res = new ArrayList<>();
        if(n==0)
            return res;
        backtrack("",n,n,res);
        return res;
    }
    public void backtrack(String cur, int left, int right, List<String>res)
    {
        if(left == 0 && right ==0)
        {
            res.add(cur);
            return;
        }
        if(left > right)
        {
            return;
        }
        if (left > 0) {
            backtrack(cur + "(", left - 1, right, res);
        }

        if (right > 0) {
            backtrack(cur + ")", left, right - 1, res);
        }

    }
}
