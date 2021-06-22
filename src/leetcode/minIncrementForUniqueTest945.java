package leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/*
力扣945：使数组唯一的最小增量
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
返回使 A 中的每个值都是唯一的最少操作次
 */
import java.util.Arrays;

public class minIncrementForUniqueTest945 {
    public static void main(String[] args) {
        minIncrementForUniqueTest945 t1 = new minIncrementForUniqueTest945();
        int[] A = new int[]{3, 2, 1, 2, 1, 7};
        System.out.println(t1.minIncrementForUnique(A));
    }

    /**
     * 使用一个额外的数组将排序后的计数个数按对应大小存储在新数组中，若当前位置的计数值大于1，将超过的部分移到到后一个位置上
     * 然后将计数增加移动的个数，直到所有位置上的值都<=1为止。
     *
     * @param A 传入的数组
     * @return 最小移动的次数
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int[] temp = new int[50000];
        for (int i = 0; i < A.length; i++) {
            temp[A[i]]++;
        }
        int res = 0;
        for (int i = 0; i < 50000; i++) {
            if (temp[i] > 1) {
                res = res + temp[i] - 1;
                temp[i + 1] = temp[i + 1] + temp[i] - 1;
                temp[i] = 1;
            }
        }
        return res;
    }

    int [] pos = new int[80000];
    public int minIncrementForUnique1(int[] A)
    {
        Arrays.fill(pos,-1);
        int move = 0;
        for(int a : A)
        {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }
    private int findPos(int a)
    {
        int b = pos[a];
        if(b == -1)
        {
            pos[a] = a;
            return a;
        }
        b = findPos(b+1);
        pos[a] = b;
        return b;
    }
}