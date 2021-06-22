package leetcode.List;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class reversePrint {
    public static void main(String[] args) {

    }
    public static int[] reversePrint(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        if(head == null)
            return new int[]{};
        while(head != null)
        {
            stack.push(head.val);
            head = head.next;
        }
        int [] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty())
        {
            res[i++] = stack.pop();
        }
        return res;
    }
}
