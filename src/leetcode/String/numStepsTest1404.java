package leetcode.String;
/*
二进制数操作，加法和除法，判断是否为奇偶数。
 */
public class numStepsTest1404 {
    public static void main(String[] args) {
        numStepsTest1404 t1 = new numStepsTest1404();
        String s = "1101";
        System.out.println(t1.numSteps(s));
        System.out.println(t1.numSteps1(s));
    }
    public int numSteps(String s)
    {
        int len = s.length();
        int nums = 0;
        int times = 0;
        if(len == 1)
        {
            return 0;
        }
        char[] chars = s.toCharArray();
        for(int i = len-1; i >= 0; i--)
        {
            nums += (chars[i]-'0')<<times;
            times++;
        }
        int step = 0;
        while(nums != 1)
        {
            if(nums%2 == 0)
            {
                nums = nums /2;
                step++;
                continue;
            }
            if(nums%2 ==1)
            {
                nums = nums + 1;
                step++;
                continue;
            }
        }
        return step;
    }
    public int numSteps1(String s)
    {
        int step = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        while(true)
        {
            if(stringBuilder.length() == 1)
                return step;
            if(stringBuilder.charAt(stringBuilder.length()-1) =='0') //偶数的情况
            {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                step++;
            }
            else if(stringBuilder.charAt(stringBuilder.length()-1) == '1') //奇数
            {
                stringBuilder.setCharAt(stringBuilder.length()-1,'0');
                step++;
                for(int i = stringBuilder.length()-2; i >= 0; i--)
                {

                    if(i == 0 && stringBuilder.charAt(i)=='1') //最高位进位情况
                    {
                        stringBuilder.setCharAt(i,'0');
                        stringBuilder.insert(i,'1');
                        break;
                    }
                    if(stringBuilder.charAt(i) == '1') //遇到1继续进位
                    {
                        stringBuilder.setCharAt(i,'0');
                    }
                    else if(stringBuilder.charAt(i) == '0') //遇到0结束进位
                    {
                        stringBuilder.setCharAt(i,'1');
                        break;
                    }
                }
            }
        }

    }

    /**
     * 二进制两数求和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        if(a.length() == 0)
            return b;
        if(b.length() == 0)
            return a;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int ptrA = a.length();
        int ptrB = b.length();
        int carry = 0; //进位标识
        while(ptrA >= 0 && ptrB >= 0)
        {
            if(charA[ptrA] == '1' && charB[ptrB] == '1')
            {
                if(carry == 0)
                    sb.insert(0,'1');
            }
        }
        return sb.toString();
    }
}
