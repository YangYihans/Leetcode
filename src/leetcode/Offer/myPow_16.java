package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/11 9:54
 * @Description 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * n == 0  pow = 1
 * n < 0   pow = 1 / x^(-n) = x * 1/ x^(-n-1)
 * n为奇数  pow = x * x^(n-1)
 * n为偶数  pow = x^2 * x*(n/2)
 */
public class myPow_16 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1 / (x * myPow(x, - n - 1));
        }else if(n % 2 == 1){
            return x * myPow(x, n - 1);
        }else{
            return myPow(x * x, n / 2);
        }
    }
}
