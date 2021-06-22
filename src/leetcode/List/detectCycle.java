package leetcode.List;

public class detectCycle {
    public static void main(String[] args)
    {


    }
    public ListNode detectCycle(ListNode head)
    {
        if(head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            return null;
        else
        {
            fast = head;
            while(fast != slow)
            {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return fast;
    }
}
