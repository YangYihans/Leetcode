package leetcode;

public class isHappyTest202 {
    public static void main(String[] args) {
        isHappyTest202 t1 = new isHappyTest202();
        System.out.println(t1.isHappy(19));
    }
    public boolean isHappy(int n )
    {
        for(int i = 0; i < 100; i++)
        {
            int ans = 0;
            while(n > 0)
            {
                ans += (n%10) * (n%10);
                n = n/10;
            }
            n = ans;
            if(n == 1)
                return true;
        }
        return false;
    }
}
