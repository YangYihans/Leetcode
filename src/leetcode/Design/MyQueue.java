package leetcode.Design;

import java.util.Stack;

/*
力扣232：用栈实现队列
使用栈实现队列的下列操作：push，pop，peek，empty
每次完事以后不用倒回去， 因为只有输出栈全部输出以后才会让输入栈的值输入， 顺序是不会变的。
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
       if(stack2.isEmpty()){
           while(!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }
       }
       return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.print(myQueue.peek());
        System.out.print(myQueue.pop());
        myQueue.push(3);
        System.out.print(myQueue.pop());
        System.out.print(myQueue.empty());
    }
}
