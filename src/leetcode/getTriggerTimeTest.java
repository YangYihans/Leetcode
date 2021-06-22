package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class getTriggerTimeTest {
    public static void main(String[] args) {
        getTriggerTimeTest t1 = new getTriggerTimeTest();
        int[][] increase = new int[][]{{2,8,4},{2,5,0},{10,9,8}};
        int[][] req = new int[][]{{2,11,3},{15,10,7},{9,17,12},{8,1,14}};
        int[] res = t1.getTriggerTime(increase,req);
        for (int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
    public int[] getTriggerTime(int[][] increase, int[][] requirements)
    {
        List<List<Integer>> requireList = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < requirements.length; i++)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < requirements[i].length; j++)
            {
                list.add(j,requirements[i][j]);
                //list.set(0,Integer.MAX_VALUE);
            }
            requireList.add(i,list);
        }
        int c = 0;
        int r = 0;
        int h = 0;
        int[] res = new int[requirements.length];
        List<List<Integer>> dummy = requireList;
        Integer integer = requireList.get(0).get(0);
        for(List list : requireList)
        {
            if(c >= (Integer) list.get(0) && r >= (Integer) list.get(1) && h >= (Integer) list.get(2))
            {
                res[dummy.indexOf(list)] = 0;
                list.set(0,Integer.MAX_VALUE);
                 requireList.remove(list);
            }
        }
        for(int i = 0; i < increase.length; i++)
        {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            for(List<Integer> list : requireList)
            {
                if(c >= (Integer) list.get(0) && r >= (Integer) list.get(1) && h >= (Integer) list.get(2) )
                {
                    res[dummy.indexOf(list)] = i+1;
                    list.set(0,Integer.MAX_VALUE);
                    requireList.remove(list);
                }
            }
        }
        for(int i = 0; i < res.length; i++)
        {
            if(res[i] == 0 && requireList.get(i).get(0) != Integer.MAX_VALUE)
                res[i] = -1;
        }
        return res;
    }
}
