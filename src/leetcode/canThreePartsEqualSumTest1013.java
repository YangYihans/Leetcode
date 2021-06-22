package leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/*
力扣1013:将数组分成和相等的三个部分
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 */
public class canThreePartsEqualSumTest1013 {
    public static void main(String[] args) {
        canThreePartsEqualSumTest1013 t1 = new canThreePartsEqualSumTest1013();
        int [] A = new int[]{18,12,-18,18,-19,-1,10,10};
        System.out.print(t1.canThreePartsEqualsSum(A));
    }
    public boolean canThreePartsEqualsSum(int[] A)
    {
        int n = A.length;
        if(n <= 2)
            return false;
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += A[i];
        }
        if(sum%3 != 0)
            return false;
        sum = sum / 3;
        int subSum1= A[0];
        int subSum2= A[n-1];
        int left = 1;
        int right = n-2;
        if(subSum1 == sum)
            left = 0;
        if(subSum2 == sum)
            right = n-1;
        while(left < right)
        {
            if(subSum1 != sum)
            {
                subSum1 = subSum1 + A[left];
                if(subSum1 != sum) //否则 right-left>=2条件不生效
                left++;
            }
            if(subSum2 != sum)
            {
                subSum2 = subSum2 + A[right];
                if(subSum2 != sum) //否则 right-left>=2条件不生效
                right--;
            }
            if(subSum1 == sum && subSum2 == sum && right-left>=2)
                return true;
            if(subSum1 == sum && subSum2 == sum && right-left <2) //添加否则死循环
                return false;
        }
        return false;
    }
}
