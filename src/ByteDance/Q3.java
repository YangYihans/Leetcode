package ByteDance;

import java.util.Arrays;
import java.util.Comparator;

public class Q3 {
    public static void main(String[] args) {
        process(new int[][]{{3,2},{3,5},{365,999},{2,3},{1,1}});
    }

    public static void process(int[][] nums){
        double[][] res = new double[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            double temp = (double) nums[i][1] / nums[i][0];
            res[i][0] = temp;
            res[i][1] = i+1;
        }
        Arrays.sort(res, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) (o2[0] - o1[0]);
            }
        });
        for (double[] re : res) {
            System.out.print((int)re[1] + " ");
        }
        System.out.println(" ");
    }
}
