package leetcode.wangyi;

import org.omg.CORBA.INTERNAL;

import java.net.Inet4Address;
import java.util.Scanner;
import java.util.*;

public class gift {
    public static void main(String[] args) {
        // 读数据 存成一个二维数组
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        int[][] score = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] s = scanner.nextLine().split(" ");
            score[i][0] = Integer.parseInt(s[0]);
            score[i][1] = Integer.parseInt(s[1]);
        }
        int gift = 0;
        int len = 0; // 统计长度
        boolean[][] used = new boolean[N][2];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            if(i == 0){
                stack.add(score[i][0]); // 存的是下标
                gift++;
                len++;
                continue;
            }
            if (stack.contains(score[i][0])) {
                Stack<Integer> temp = new Stack<>();
                while (stack.peek() != score[i][0]) {
                    temp.push(stack.pop());
                }
                stack.pop();
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
            process(stack, score, i, len, gift, used);
        }
        System.out.println(gift);
    }

    public static void process(Stack<Integer> stack, int[][] score, int i, int len, int gift, boolean[][] used){
        int current = score[i][1];
        Stack<Integer> temp = new Stack<>();
        int x = score[stack.peek()-1][1];
        while(current < score[stack.peek()-1][1]){
            temp.push(stack.pop());
        }
        stack.push(score[i][0]);
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        len++;
        int index = Integer.MIN_VALUE, index1 = Integer.MIN_VALUE;
        if(len % 2 == 0){
            index = (int) Math.floor(len / 2);
            index1 = (int) Math.floor(len / 2) - 1;
        }else{
            index = (int) Math.floor(len / 2);
        }
        double mid = index1 == Integer.MIN_VALUE ?  score[stack.get(index)-1][1] : (score[stack.get(index)-1][1] + score[stack.get(index1)-1][1]) / 2.0;
        if(mid == score[i][1] && !used[i][0]){
            gift++;
            used[i][0] = true;
        }
    }


}
