package leetcode;
/*
38.外观数列
思路：将字符串转化为char型数组进行操作，相同递增，不同直接输出。
 */
public class countAndSayTest38 {
    public static void main(String[] args) {
        countAndSayTest38 t1 = new countAndSayTest38();
        System.out.println(t1.countAndSay(6));
    }
    public String countAndSay(int n)
    {
        String res = "1211";
        if(n == 1)
        {
            res = "1";
            return res;
        }
        if(n == 2)
        {
            res = "11";
            return res;
        }
        if(n == 3)
        {
            res = "21";
            return res;
        }
        if(n == 4)
        {
            res = "1211";
            return res;
        }
        else
        {
            while(n>4)
            {
                n--;
                char [] arg = res.toCharArray();
                res = "";
                int count = 1;
                for(int i = 0; i < arg.length; i++)
                {
                    if(i < arg.length -2)
                    {
                        if(arg[i] == arg[i+1])
                        {
                            count++;
                            continue;
                        }
                        else
                        {
                            res = res + count + arg[i];
                            count = 1;
                            continue;
                        }
                    }
                    if(i == arg.length-2)
                    {
                        if(arg[i] == arg[i+1])
                        {
                            count++;
                            res = res + count + arg[i];
                            break;
                        }
                        else
                        {
                            res =res + count + arg[i];
                            count = 1;
                            res =res + count + arg[i+1];
                            break;
                        }
                    }
                }
            }
        }
        return  res;
    }
}
