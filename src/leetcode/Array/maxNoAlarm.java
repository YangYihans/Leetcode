package leetcode.Array;

import java.util.Scanner;

public class maxNoAlarm {
    public static int Solution(int[] arr, int s){

        int max = 0;
        int i = 0;
        int j = 0;
        int len = arr.length;
        int sum = 0;
        while (j < len){
            if(sum + arr[j] <= s){
                sum += arr[j];
                j++;
            }else{
                max = Math.max(max, j - i);
                if(i < j) {
                    sum -= arr[i];
                    i++;
                }else {
                    i++;
                    j++;
                }
            }

        }
        max = Math.max(max, j - i);
        return max;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        Integer n = Integer.parseInt(arr[0]);
        Integer k = Integer.parseInt(arr[1]);
        int[] intArr = new int[n];
        for(int i = 0; i < n; i++){
            intArr[i] = scanner.nextInt();
        }
        System.out.println(Solution(intArr, k));

    }
}
