package ByteDance.Number;

import java.util.Stack;

/**
 * 接雨水
 */
public class trap {
    public static int trap(int[] height)
    {
        int n = height.length;
        if(height == null)
            return -1;
        if(n == 1)
            return 0;
        int i = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < n)
        {
            if(i == 0 && height[0] == 0)//针对最开始为空的情况
            {
                i++;
                continue;
            }
            if(i == n-1 && height[i] < height[i-1])
                break;
            while(!stack.isEmpty() && height[i] > height[stack.peek()])//现在的比栈顶的元素大
            {
                int mid = stack.pop();
                while(!stack.isEmpty() && height[mid] == height[stack.peek()])
                {
                    stack.pop();
                }
                if(!stack.isEmpty())
                {
                    int left = stack.peek();//不能使用pop，要让进来的值和存入栈中的都比对了
                    res += (Math.max(height[left], height[i])-height[mid]) * (i - left -1);
                }
            }
            stack.push(i);
            i++;
        }
        return res;
    }
}
