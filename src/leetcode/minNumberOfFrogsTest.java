package leetcode;

public class minNumberOfFrogsTest {
    public static void main(String[] args) {
        minNumberOfFrogsTest t1 = new minNumberOfFrogsTest();
        String x = "crcoakroak";
        System.out.println(t1.minNumberOfFrogs(x));
    }
    public int minNumberOfFrogs(String croakOfFrogs)
    {
        String temp = "croak";
        if(croakOfFrogs.length() < 5)
            return -1;
        int res = 0;
        String trim = "";
        if(croakOfFrogs.contains(temp))
        {
            res = 1;
            croakOfFrogs = croakOfFrogs.replaceAll("croak","+");
        }
        int i = 0;
        int [] count = new int[5];
        char[] chars = croakOfFrogs.toCharArray();
        while(i < croakOfFrogs.length())
        {
            if(chars[0] != 'c')
                return -1;
            if(chars[i] == 'c')
            {
                count[0]++;
            }
            else if(chars[i] == 'r')
            {
                count[1]++;
            }
            else if(chars[i] == 'o')
            {
                count[2]++;
            }
            else if(chars[i] == 'a')
            {
                count[3]++;
            }
            else if(chars[i] == 'k')
            {
                count[4]++;
            }
        }
        if(count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4])
        {
            i = 0;
            while(true)
            {
                int index =  croakOfFrogs.indexOf('c');
                chars[index] = '.';
                index = croakOfFrogs.indexOf('r');
                if(index > croakOfFrogs.indexOf('c'))
                    return -1;
                chars[index] = '.';
                index = croakOfFrogs.indexOf('o');
                if(index > croakOfFrogs.indexOf('r'))
                    return -1;
                chars[index] = '.';
                index = croakOfFrogs.indexOf('a');
                if(index> croakOfFrogs.indexOf('o'))
                    return -1;
                chars[index] = '.';
                index = croakOfFrogs.indexOf('k');
                if(index > croakOfFrogs.indexOf('a'))
                    return -1;
                chars[index] = '.';
                i  = i + 5;
                res ++;
                if(i == croakOfFrogs.length())
                    return res;
            }

        }
        return -1;
    }
}
