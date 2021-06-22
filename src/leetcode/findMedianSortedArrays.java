package leetcode;

public class findMedianSortedArrays {
    public static void main(String [] args)
    {
        findMedianSortedArrays t1 = new findMedianSortedArrays();
        int[] a = new int[]{1,2};
        int[] b = new int[]{};
        System.out.println(t1.findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = n + m;
        int left = -1;
        int right = -1;
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= len / 2; i++)
        {
            left = right;
            if(aStart < m &&(bStart >= n || A[aStart] < B[bStart]))
            {
                right = A[aStart];
                aStart++;
            }
            else
            {
                right = B[bStart];
                bStart++;
            }
        }
        if(len % 2 == 0)
            return  (left + right)/2.0;
        return right;
    }
}
