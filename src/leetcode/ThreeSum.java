package leetcode;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(analysis("1211211 1212"));

    }
    public static int analysis(String expression)
    {
         String[] strings = expression.split(" ");
         char[] charA = strings[0].toCharArray();
         char[] charB = strings[1].toCharArray();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = charA.length -1, j = charB.length -1; i >= 0 || j >= 0; i--, j--)
        {
            int sum = carry;
            sum += i >= 0 ? charA[i]-'0' : 0;
            sum += j >= 0 ? charB[j]-'0' : 0;
            sb.append(sum%3);
            carry = sum/3;
        }
        sb.append(carry == 1? carry : "");
        //System.out.println(sb.reverse().toString());
        return Integer.parseInt(sb.reverse().toString());
    }
}
