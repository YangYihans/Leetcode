package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class processQueriesTest {
    public static void main(String[] args) {
        processQueriesTest t1 = new processQueriesTest();
        int [] queries = new int[]{10,7,3,3,9,4,1,4,9,9};
        int [] res = t1.processQueries(queries,10);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
/*    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];
        if (len == 1) {
            res[0] = 0;
            return res;
        }
        int[] p = new int[m];
        for(int i = 0; i < m; i++)
        {
            p[i] = i+1;
        }
        String s = "";
        for(int i = 0; i < m; i++)
        {
            s = s + p[i];
        }
        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < len; i++)
        {
            int index = stringBuilder.indexOf(String.valueOf(queries[i]));
            res[i] = index;
            stringBuilder.deleteCharAt(index);
            stringBuilder.insert(0,String.valueOf(queries[i]));
        }
        return  res;
    }*/
    public int[] processQueries(int[] queries, int m)
    {
        int len = queries.length;
        List<Integer> list = new LinkedList<Integer>();
        int[] res = new int[len];
        if(len == 1)
        {
            res[0] = queries[0]-1;
            return res;
        }
        for(int i = 1; i <= m; i++)
        {
            list.add(i);
        }
        for(int i = 0; i < len; i++)
        {
            int index = list.indexOf(queries[i]);
            res[i] = index;
            list.remove(new Integer(queries[i]));
            list.add(0,queries[i]);
        }
        return res;
    }
}
