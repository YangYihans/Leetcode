package ByteDance.Number;

import java.util.ArrayList;
import java.util.Scanner;

public class shuiXianHuaShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            ArrayList<Integer> list = new ArrayList<>();
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int i = start; i <= end; i++)
            {
                if(isTrue(i))
                {
                    list.add(i);
                }
            }
            if(list.size() == 0)
                System.out.println("no");
            else
            {
                for(int i = 0; i < list.size(); i++)
                {
                    if(i == list.size()-1)
                        System.out.println(list.get(i));
                    else
                        System.out.print(list.get(i) + " ");
                }
            }

        }
    }
    public static boolean isTrue(int n)
    {
        int sum = 0;
        int num = n;
        while(num != 0)
        {
            int temp = num%10;
            sum += temp*temp*temp;
            num = num/10;
        }
        return sum == n;
    }
}
