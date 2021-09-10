package Baidu;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(process("eeeeaaasssyyyeesayeasyeaseey"));
    }

    public static int process(String s){
        StringBuilder ss = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                ss.append(Character.toLowerCase(c));
            }else{
                ss.append(c);
            }
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('e', Integer.MAX_VALUE);
        map.put('a', Integer.MAX_VALUE);
        map.put('s', Integer.MAX_VALUE);
        for (int i = 0; i < ss.length(); i++){
            if(ss.charAt(i) == 'e'){
                if(i > map.get('a')){
                    continue;
                }
                map.put('e', i);
            }else if(ss.charAt(i) == 'a'){
                if (i > map.get('s')) {
                    continue;
                }
                map.put('a', i);
            }else if(ss.charAt(i) == 's'){
                if(i < map.get('a')){
                    continue;
                }
                map.put('s', i);
            }else if(ss.charAt(i) == 'y'){
                boolean flag = check(map, i);
                if(flag){
                    res++;
                    map.put('e', Integer.MAX_VALUE);
                    map.put('a', Integer.MAX_VALUE);
                    map.put('s', Integer.MAX_VALUE);
                }

            }
        }
        return res;
    }

    public static boolean check(Map<Character, Integer> map, int i){
        return map.get('e') < map.get('a') && map.get('a') < map.get('s') && map.get('s') < i;
    }
}
