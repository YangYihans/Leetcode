package ali;

import org.omg.CORBA.INTERNAL;

import java.util.Scanner;
import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < t; i++){
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int times = Integer.parseInt(s[1]);
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = j + 1;
            }
            process(nums, times);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void process(int[] nums, int times){
        if(nums.length == 1){
            System.out.println(nums[0]);
            return;
        }
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int index = i;
            list.add(i);
            used[i] = true;
            while(2 * index + 1 < nums.length){
                list.add(2 * index + 1);
                used[2 * index + 1] = true;
                index = 2 * index+ 1;
            }
            res.add(list);
        }
        for (List<Integer> tmpList : res) {
            int len = tmpList.size();
            times = times % len;
            int j = 0;
            int tempNum = nums[tmpList.get(0)];
            for (int k = 0; k < len - 1; k++) {
                int update = (j + times) % len;
                nums[tmpList.get(j)] = nums[tmpList.get(update)];
                j = update;
            }
            nums[tmpList.get(j)] = tempNum;
        }
    }
}
