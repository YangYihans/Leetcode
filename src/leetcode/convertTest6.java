package leetcode;
/*
6.Z字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。之后，你的输出需要从左往右逐行读取，产生出一个新的字符串
2020.2.13
 */
public class convertTest6 {
    public static void main(String[] args) {
        convertTest6 t1 = new convertTest6();
        System.out.println(t1.convert("LEETCODEISHIRING",4));
    }
    public String convert(String s, int numRows)
    {
        String res = "";
        int n = s.length();
        if(n <= numRows) {
            res = s;
            return res;
        }
        for(int i = 0; i < numRows; i++)
        {
            if(i == 0)
            {
                int j = 0;
                while(j<n)
                {
                    res = res + s.charAt(j);
                    j = j + 2 * numRows-2;
                }
                continue;
            }
            if(i == numRows-1)
            {
                int j = numRows-1;
                while(j < n)
                {
                    res = res + s.charAt(j);
                    j = j + 2 * numRows -2;
                }
                continue;
            }
            else
            {
                int j = i;
                res = res + s.charAt(j);
                int count = 1;
                while(j < n)
                {
                    if(count % 2 != 0)
                    {
                        j = j + 2 * numRows - 2 *i -2;
                        if(j >= n)
                            break;
                        res = res + s.charAt(j);
                        count++;
                    }
                    if(count % 2 ==0)
                    {
                        j = j + 2 * i;
                        if(j >= n)
                            break;
                        res = res + s.charAt(j);
                        count++;
                    }
                }
            }
        }
        return res;
    }
}
