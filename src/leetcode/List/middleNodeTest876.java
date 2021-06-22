package leetcode.List;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.event.ListDataEvent;
import java.util.List;

public class middleNodeTest876 {
    public static void main(String[] args) {
        middleNodeTest876 t1 = new middleNodeTest876();
        ListNode listNode = new ListNode(1);
    }
    public ListNode middleNode(ListNode head)
    {
        ListNode current = head;
        int n = 0;
        if(head == null)
            return head;
        while(current.next != null)
        {
            n++;
            current = current.next;
        }

        if(n%2 == 0)
        {
            int i = 0;
            while(i < n/2)
            {
                i++;
                head = head.next;
            }
        }
        if(n%2 ==1)
        {
            int i = 0;
            while(i <= n/2)
            {
                i ++;
                head = head.next;
            }
        }
        return head;
    }

    /**
     * 快慢指针的问题，快指针一次移动两次，慢指针一次移动一次，当快指针移动到末尾的时候，慢指针刚好移动到中间位置
     * @param head 传入的链表
     * @return 返回从中间结点开始的链表
     */
    public ListNode middleNode1(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
