package leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class getLeastNumbersTest {
    public static void main(String[] args) {
        getLeastNumbersTest t1 = new getLeastNumbersTest();
        int[] arr = new int[]{};
        int[] res = t1.getLeastNumbers(arr,1);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
    public int[] getLeastNumbers(int[] arr, int k)
    {
        if(arr.length == 0 || k >= arr.length)
            return arr;
        if(k == 0)
            return new int[]{};
        Arrays.sort(arr);
        int [] res = new int[k];
        for(int i = 0; i < k ;i++)
        {
            res[i] = arr[i];
        }
        return res;
    }
}
