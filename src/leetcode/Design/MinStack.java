package leetcode.Design;

import netscape.security.UserTarget;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(helper.isEmpty() || x < helper.peek())
            helper.push(x);
        else
            helper.push(helper.peek());
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args)
    {
        MinStack t1 = new MinStack();
        t1.push(0);
        t1.push(1);
        t1.push(0);
        System.out.println(t1.getMin());
        t1.pop();
        System.out.println(t1.getMin());
    }
}
