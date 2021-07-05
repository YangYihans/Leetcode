package leetcode.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * [对于找最近一个比当前值大/小]的问题——————均可以使用单调栈来解决
 *      1.最近 --- 栈顶， 更大 --- 更大出栈， 更小入栈。
 *      2.栈内存放的永远是还没有更新答案的下标。
 *
 * [对于本题的循环数组]：
 *      1.要找的目标要么是在当前元素之前，要么是在当前元素之后，所以两次遍历肯定都能够覆盖。
 *
 */
public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);  //默认值为-1
        Stack<Integer> stack = new Stack<>();  // stack中存放的是索引
        for(int i = 0; i < 2 * len; i++){
            int num = nums[i % len];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < len){
                stack.push(i);
            }
        }
        return res;
    }
}
