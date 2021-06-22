package leetcode.Array;

import java.util.Arrays;
import java.util.Scanner;

public class maxInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        if(N == 0)
            return;
        int[] nums = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++)
        {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for(int i = 0; i < N; i++)
        {
            sum += nums[i];
        }
        int max = nums[N-1]*nums[N-1];
        for(int i = 0; i < N; i++)
        {
            if(nums[i]*sum > max)
            {
                max = nums[i]*sum;
            }
            sum -= nums[i];
        }
        System.out.println(max);
    }
}
