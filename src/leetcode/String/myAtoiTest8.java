package leetcode.String;

public class myAtoiTest8 {
    public static void main(String[] args) {
        myAtoiTest8 t1 = new myAtoiTest8();
        String str = "  +-0000000000012345678";
        System.out.println(t1.myAtoi(str));

    }
    public int myAtoi(String str)
    {
        if(str.length() == 0 || str == null)
            return 0;
        int symbol = 0;
        int i = 0;
        char[] chars = str.toCharArray();
        int result = 0;
        int len = chars.length;
        while(i < len && chars[i] == ' ')
        {
            i++;
        }
        if(i == len)
            return 0;
        if(chars[i] == '-')
        {
            symbol = -1;
            i++;
        }
        if(chars[i] == '+')
        {
            symbol = 1;
            i++;
        }
        while (i < len && Character.isDigit(chars[i]))
        {
            int digit = chars[i] - '0';
            if(result > (Integer.MAX_VALUE-digit) / 10)
                return symbol == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + digit;
            i++;
        }
        return symbol == -1? -result : result;
    }
}
