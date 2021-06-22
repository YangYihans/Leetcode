package leetcode.String;

public class entityParserTest {
    public static void main(String[] args) {
        entityParserTest t1 = new entityParserTest();
        String text = "leetcode.com&frasl;problemset&frasl;all";
        System.out.println(t1.entityParser(text));
    }
    public String entityParser(String text)
    {
        if(text == null)
            return "";
        char[] chars = text.toCharArray();
        String res = "";
        int flag = 0;
        int i = 0;
        while(i < chars.length)
        {
            String temp = "";
            flag = 0;
            if(chars[i] == '&')
            {
                flag = 1;
                while(chars[i] != ';')
                {
                    temp += chars[i];
                    i++;

                }
                temp += chars[i];
            }
            if(flag == 0)
            {
                res += chars[i];
                i++;
                continue;
            }
            if(temp.equals("&quot;"))
                temp = "\"";
            else if(temp.equals("&apos;"))
                temp = "\'";
            else if(temp.equals("&amp;") )
                temp = "&";
            else if(temp.equals("&gt;"))
                temp = ">";
            else if(temp.equals("&lt;"))
                temp = "<";
            else if(temp.equals("&frasl;"))
                temp = "/";
            else
                temp = temp;
            if(flag == 1)
            {
                res += temp;
            }
            i++;

        }
        return res;
    }
}
