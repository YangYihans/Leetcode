package leetcode.Array;

import java.util.Stack;

public class trapTest42 {
    public static void main(String[] args) {
        trapTest42 t1 = new trapTest42();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t1.trap(height));
    }
    public int trap(int[] height)
    {
        int n = height.length;
        if(height == null)
        {
            return -1;
        }
        if(n == 1)
            return -1;
        int i = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < n)
        {
            if(i == 0 && height[i] == 0)
            {
                i++;
                continue;
            }
            if(i == n-1 && height[i-1] >= height[i])
                break;
            while(!stack.isEmpty() && height[stack.peek()] < height[i])
            {
                int mid = stack.pop(); //中间的下标
                while(!stack.isEmpty() && height[stack.peek()] == height[mid])
                {
                    stack.pop();
                }
                if(!stack.isEmpty())
                {
                    int left = stack.peek();
                    res += (Math.min(height[left],height[i])-height[mid]) * (i - left -1);
                }

            }
            stack.push(i);
            i++;
        }
        return res;
    }
}
