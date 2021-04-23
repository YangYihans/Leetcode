package leetcode.Breadth_First_Search;

import java.util.*;

/**
 * @Author Yang
 * @Date 2021/4/23 10:17
 * @Description 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6','7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋
 * 转一个拨轮的一位数字。锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 */
public class openLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        Set<String> visited = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();
        dq.add("0000");
        visited.add("0000");
        int step = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                String s = dq.poll();
                if(deads.contains(s)){
                    continue;
                }
                if(s.equals(target)){
                    return step;
                }
                for(int j = 0; j < 4; j++){
                    String temp = add(s, j);
                    if(!visited.contains(temp)){
                        dq.add(temp);
                        visited.add(temp);
                    }
                    String down = sub(s, j);
                    if(!visited.contains(down)){
                        dq.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static String add(String s, int j){
        char[] chars = s.toCharArray();
        if(chars[j] == '9'){
            chars[j] = '0';
        }else{
            chars[j] = (char) (chars[j] + 1);
        }
        return new String(chars);
    }

    public static String sub(String s, int j){
        char[] chars = s.toCharArray();
        if(chars[j] == '0'){
            chars[j] = '9';
        }else{
            chars[j] = (char) (chars[j] - 1);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
