package leetcode;

public class mergeTwoNums {
    public static void main(String[] args) {
        mergeTwoNums t1 = new mergeTwoNums();
        int [] a = new int[]{1,7,8,0,0,0};
        int [] b = new int[]{2,5,6};
        t1.merge(a,3,b,3);
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]+" ");
        }
    }
    public void merge(int[] a, int m, int[] b, int n)
    {
        int [] c = new int[m+n];
        if(m==0 || n == 0)
            return;
        int i = 0;
        int j = 0;
        int temp = 0;
        int k = 0;
        while(i < m && j < n)
        {
            if(a[i] <= b[j])
            {
                c[k] = a[i];
                k++;
                i++;
            }
            else
            {
                c[k] = b[j];
                k++;
                j++;
            }
        }
        if(i == m)
        {
            for(; j<n; j++)
            {
                c[k] = b[j];
                k++;
            }
        }
        else
        {
            for(; i<m; i++)
            {
                c[k] = a[i];
                k++;
            }
        }
        for(k = 0; k < c.length; k++)
        {
            a[k] = c[k];
        }
        return;
    }
}
