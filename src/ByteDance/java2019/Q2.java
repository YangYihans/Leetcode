package ByteDance.java2019;

import netscape.security.UserTarget;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String[] s = next.split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        String nums_string = scanner.nextLine();
        String[] nums = nums_string.split(" ");
        int result = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        process(res, path, n, d, 0, 0, nums, used);
        System.out.println(res.size() % 99997867);
    }

    public static void process(List<List<Integer>>res, List<Integer> path, int n, int d, int depth, int start, String[] nums, boolean[] used){
        if(depth == 3){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length; i++){
            String num = nums[i];
            if(!used[i]){
                if(path.size() != 0 && Integer.parseInt(num) - path.get(0) > d){
                    break;
                }
                path.add(Integer.parseInt(num));
                used[i] = true;
                process(res, path, n, d, depth+1,i+1, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);

            }
        }
    }


}


class main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        if(n < 3){
            System.out.println(-1);
        }
        int left = 0;
        int right = 2;
        long res = 0;
        while(left < n -2){
            while(right < n && nums[right] - nums[left] <= d){  // 滑动找右边界
                right++;
            }
            if(right - left >= 3){  // 条件不满足就计算当前有多个数
                int num = right - left - 1;
                res += num * (num - 1) / 2;
            }
            left++;  // 进行下一次循环
        }
        System.out.println(res);
    }
}

