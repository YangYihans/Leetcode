package ByteDance.Number;

import java.text.NumberFormat;
import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            /*String str = sc.nextLine();
            String[] s = str.split(" ");
            double num = Integer.parseInt(s[0]);
            int times = Integer.parseInt(s[1]);*/
            double num = sc.nextDouble();
            int times = sc.nextInt();
            double res = num;
            for(int i = 0; i < times-1; i++)
            {
                num = Math.sqrt(num);
                res += num;
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            System.out.println(nf.format(res));
        }
    }
}
