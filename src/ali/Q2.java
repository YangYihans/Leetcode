package ali;

public class Q2 {
    private static int[][] choose = new int[][]{{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    public static void main(String[] args) {
        System.out.println(process(100, 100));
    }
    public static double process(int num1, int num2){
        if(num1 <= 0 && num2 > 0){
            return 1;
        }else if(num1 <= 0 && num2 <= 0){
            return 0.5;
        }else if(num1 > 0 && num2 <= 0){
            return 0;
        }
        return 0.25 * (process(num1 - choose[0][0], num2 - choose[0][1]) + process(num1 - choose[1][0], num2 - choose[1][1]) +
                process(num1 - choose[2][0], num2 - choose[2][1]) + process(num1 - choose[3][0], num2 - choose[3][1]));
    }

}
