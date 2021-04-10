package leetcode.Design;

import java.util.LinkedList;
import java.util.List;

/*
力扣225.用队列实现栈
使用队列实现栈的下列操作：push、pop、top、empty
思路：双队列，一个队列用于入队，出队时将入队队列中除最后一个元素外的其余元素依次弹出，写入另外一个队列，在完成push或者pop操作之后两个队列交换，保持出队的队列
在每次pop，push操作开始时为空
 */
public class MyStack {
    private List<Integer> list1;
    private List<Integer> list2;

    public MyStack()
    {
        list1 = new LinkedList();
        list2 = new LinkedList();
    }
    public void push(int x)
    {
        list1.add(x);
    }
    public int pop()
    {
        int n = list1.size();
        int temp = 0;
        int i = 0;
        while(i<=n-2)
        {
            temp = list1.get(0);
            list2.add(temp);
            list1.remove(0);
            i++;
        }

        int pop = list1.get(0);
        list1.remove(0);
        List<Integer> swap = new LinkedList<>();
        swap = list1;
        list1 = list2;
        list2 =swap;
        return pop;
    }
    public int top()
    {
        int n = list1.size();
        int temp = 0;
        int i = 0;
        while(i<=n-2)
        {
            temp = list1.get(0);
            list2.add(temp);
            list1.remove(0);
            i++;
        }
        int top = list1.get(0);
        list2.add(top);
        list1.remove(0);
        List<Integer> swap = new LinkedList<>();
        swap = list1;
        list1 = list2;
        list2 =swap;
        return top;
    }
    public boolean empty()
    {
        if(list1.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.print(myStack.pop());
        System.out.print(myStack.pop());
        System.out.print(myStack.pop());
        System.out.print(myStack.pop());
    }
}
