package ByteDance.java2019;

import java.util.*;
class Q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 数字后面的换行，要记得去掉这个干扰。
        sc.nextLine();
        while(n-- > 0) {
            StringBuffer sb = new StringBuffer(sc.nextLine());
            for(int i = 2; i < sb.length(); i++) {
                if(sb.charAt(i-2) == sb.charAt(i-1) && sb.charAt(i-1) == sb.charAt(i)) {
                    // AAA -> AA
                    sb.deleteCharAt(i);
                    i--;
                }else if(i >= 3 && sb.charAt(i-3) == sb.charAt(i-2) && sb.charAt(i-1) == sb.charAt(i)){
                    // helloo -> hello
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
