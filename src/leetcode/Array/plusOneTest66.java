package leetcode.Array;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class plusOneTest66 {
    public static void main(String[] args) {
        plusOneTest66 t1 = new plusOneTest66();
        int[] digit = new int[]{9,9,9};
        int[] res = t1.plusOne(digit);
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]+ " ");
        }
    }
    public int[] plusOne(int[] digits)
    {
        int len = digits.length;
        List<Integer> list = new ArrayList<>();
        if(len == 0)
        {
            return new int[]{};
        }
        int i = len -1;
        int index = 0;
        for(; i >= 0; i--)
        {
            if(i == 0 && digits[i] == 9)
            {
                list.add(index,0);
                list.add(index+1,1);
                break;
            }
            if(digits[i] == 9)
            {
                list.add(index,0);
                index++;
            }
            else
            {
                list.add(index,digits[i]+1);
                index++;
                break;
            }
        }

        for(i=i-1; i >=0; i--)
        {
            list.add(index,digits[i]);
            index++;
        }
        int[] res = new int[list.size()];
        int res_index = 0;
        for(int j = list.size()-1; j >= 0;j--)
        {
            res[res_index] = list.get(j);
            res_index++;
        }
        return res;
    }


}
