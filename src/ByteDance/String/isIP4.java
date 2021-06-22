package ByteDance.String;

public class isIP4 {
    public static void main(String[] args) {
        System.out.println(isIP4("112.111..255"));
    }
    public static boolean isIP4(String ip)
    {
        ip = ip.trim();
        if(ip.contains("."))
        {
            String[] split = ip.split("\\.");
            int len = split.length;
            if(len != 4)
                return false;
            for(int i = 0; i < len; i++){
                if(split[i].equals(""))
                    return false;
                int num = Integer.parseInt(split[i]);
                if(num >255 || (num < 10 && split[i].length()>1) || (num < 100 && split[i].length()>2))
                    return false;
            }
            return true;
        }
        return false;
    }
}
