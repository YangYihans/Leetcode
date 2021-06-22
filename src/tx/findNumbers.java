package tx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * @Author Yang
 * @Date 2021/4/4 11:40
 * @Description 经典贪心区间问题
 */
public class findNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] interval = new int[n][2];
        for(int i = 0; i < n; i++){
            interval[i][0] = sc.nextInt();
            interval[i][1] = sc.nextInt();
        }
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int index = 0;
        int count = 0;
        int right = 0;
        while(right < l){
            if(interval[index][0] > right){
                System.out.println(-1);
            }
            int max = 0;
            while(index < n && interval[index][0] <= right){
                max = Math.max(max, interval[index][1]);
                index++;
            }
            count++;
            right = max;
            if(right > l){
                System.out.println(count);
                return;
            }
            if(index >= n){
                System.out.println(-1);
                return;
            }

        }

    }
}
