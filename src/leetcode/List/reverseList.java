package leetcode.List;

import java.util.Stack;
//反转链表
public class reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        Stack<Integer> stack = new Stack();
        while(head != null)
        {
            stack.push(head.val);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(!stack.isEmpty())
        {
            current.next = new ListNode(stack.pop());
            current = current.next;
        }
        current.next = null;
        return dummy.next;
    }

    //递归方式
    public ListNode revoseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = revoseList1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }


    public ListNode reverseListII(ListNode head){
        ListNode pre = null;
        ListNode successor = null;
        ListNode current = head;
        while(current != null){
            successor = current.next;
            current.next = pre;
            pre = current;
            current = successor;
        }
        return pre;
    }
}
