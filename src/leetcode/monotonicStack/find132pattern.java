package leetcode.monotonicStack;


import java.util.ArrayDeque;
import java.util.Deque;

public class find132pattern {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--){
            if(nums[i] < k){
                return true;
            }
            while(!dq.isEmpty() && dq.peekLast() < nums[i]){
                k = Math.max(k, dq.pollLast());
            }
            dq.addLast(nums[i]);
        }
        return false;
    }
}
