package ByteDance.Greedy;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 

 */
public class lemonadeChange {
    public static void main(String[] args) {
        int[] bills = new int[]{5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills)
    {
        int five = 0;
        int ten = 0;
        for(int bill: bills)
        {
            if(bill == 5)
                five++;
            else if(bill == 10)
            {
                if(five > 0)
                {
                    five--;
                    ten++;
                }
                else
                    return false;
            }
            else if(bill == 20)
            {
                if(ten >= 1 && five>=1)
                {
                    ten--;
                    five--;
                }
                else if(five>=3)
                {
                    five -= 3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}
