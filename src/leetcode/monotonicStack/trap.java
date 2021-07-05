package leetcode.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 * 思想：单调队列
 */
public class trap {
    public int trap(int[] height){
        int n = height.length;
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            /**
             * 当前出栈的元素，它的前一个元素和后一个元素都比它大
             */
            while(!dq.isEmpty() && height[i] > height[dq.peekLast()]){
                int cur = dq.pollLast();
                /**
                 * 处理左边界的情况
                 */
                if(dq.isEmpty()){
                    continue;
                }
                int left = dq.peekLast();
                int wight = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[cur];
                ans += wight * h;
            }
            dq.addLast(i);
        }
        return ans;
    }
}
