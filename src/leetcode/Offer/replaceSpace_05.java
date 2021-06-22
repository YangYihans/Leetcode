package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/4/29 17:52
 * @Description 剑指 Offer 05. 替换空格
 */
public class replaceSpace_05 {
    public static String replaceSpace(String s) {
        if(s == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char t : chars){
            if(t == ' '){
                sb.append("%20");
            }else{
                sb.append(t);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
