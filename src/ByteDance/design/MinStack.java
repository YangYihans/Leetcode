package ByteDance.design;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack()
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x)
    {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }
    public void pop()
    {
        int x = stack.pop();
        if(x == minStack.peek())
            minStack.pop();
    }
    public int top()
    {
        return stack.peek();
    }
    public int getMin()
    {
        return minStack.peek();
    }
    public static void main(String[] args)
    {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.pop();
        System.out.println(obj.getMin());
    }
}
