package leetcode.wangyi;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class pen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double R1 = Double.parseDouble(s[0]);
        double X1 = Double.parseDouble(s[1]);
        double Y1 = Double.parseDouble(s[2]);
        double X3 = Double.parseDouble(s[3]);
        double Y3 = Double.parseDouble(s[4]);
        double len = Math.sqrt((X1-X3) * (X1 - X3) + (Y1 - Y3) + (Y1 - Y3));
        double R2 = (len + R1) / 2;
        double X2 = 0;
        double Y2 = 0;
        double diff = R2 - len;
        if(X1 <= X3 && Y1 <= Y3){
            X2 = X1 - (X3 - X1) * diff / len;
            Y2 = Y1 - (Y3 - Y1) * diff / len;
        }
        else if(X1 <= X3 && Y1 > Y3){
            X2 = X1 - (X3 - X1) * diff / len;
            Y2 = Y1 + (Y1 - Y3) * diff / len;
        }
        else if(X1 > X3 && Y1 <= Y3){
            X2 = X1 + (X1 - X3) * diff / len;
            Y2 = Y1 - (Y3 - Y1) * diff / len;
        }
        else{
            X2 = X1 + (X1 - X3) * diff / len;
            Y2 = Y1 + (Y1 - Y3) * diff / len;
        }
        System.out.println(X2 + " " + Y2 + " " + R2);
    }
}
