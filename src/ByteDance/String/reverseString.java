package ByteDance.String;
/**
 * @Author Yang
 * @Date 2021/3/24 17:34
 * @Description 344.翻转字符串
 */
public class reverseString {
    public void reverseString(char[] s){
        int len = s.length;
        if(len < 2){
            return;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * @Author Yang
     * @Date 2021/3/24 17:37
     * @Description 557.翻转字符串中的单词
     * 保留空格和单词间的初始顺序
     */
    public String reverseWords(String s){
        if(s == null){
            return s;
        }
        String[] split = s.split(" ");
        String res = "";
        int len = split.length;
        for(int i = 0; i < len; i++){
            char[] chars = split[i].toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            res += String.valueOf(chars) + " ";
        }
        return res.trim();
    }
}
