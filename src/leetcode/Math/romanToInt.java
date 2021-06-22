package leetcode.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yang
 * @Date 2021/5/15 9:36
 * @Description 13. 罗马数字转整数
 * 给定一个罗马数字，将其转换成整数。
 */
public class romanToInt {
    public static int romanToInt(String s){
        int result = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < chars.length){
            char t = chars[i];
            if(i < chars.length - 1){
                if(t == 'I'){
                    if(chars[i+1] == 'V'){
                        result += 4;
                        i += 2;
                        continue;
                    }
                    else if(chars[i+1] == 'X'){
                        result += 9;
                        i += 2;
                        continue;
                    }
                }
                else if(t == 'X'){
                    if(chars[i+1] == 'L'){
                        result += 40;
                        i += 2;
                        continue;
                    }else if(chars[i+1] == 'C'){
                        result += 90;
                        i += 2;
                        continue;
                    }
                }else if(t == 'C'){
                    if(chars[i+1] == 'D'){
                        result += 400;
                        i += 2;
                        continue;
                    }else if(chars[i+1] == 'M'){
                        result += 900;
                        i += 2;
                        continue;
                    }
                }
            }
            if(t == 'I'){
                result += 1;
            }else if(t == 'V'){
                result += 5;
            }else if(t == 'X'){
                result += 10;
            }else if(t == 'L'){
                result += 50;
            }else if(t == 'C'){
                result += 100;
            }else if(t == 'D'){
                result += 500;
            }else{
                result += 1000;
            }
            i++;
        }
        return result;
    }

    public static int romanToInt_II(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int value = map.get(chars[i]);
            if(i < chars.length - 1 && value < map.get(chars[i+1])){
                result -= value;
            }else{
                result += value;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt_II("MCMXCIV"));
    }
}
