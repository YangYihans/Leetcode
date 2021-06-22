package leetcode.List;
/*
142.环形链表
给定一个链表，返回链表开始入环的第一个节点。
如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。
 */
public class detectCycleTest142 {
    public static void main(String[] args)
    {
        detectCycleTest142 t1 = new detectCycleTest142();
    }

    /**
     * 先判断是否有环，当快慢指针相遇的时候，
     * 将慢指针继续向后移动，将快指针指向头结点，两者都变成一次移动一步，
     * 第一次相遇的节点一定是头结点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head)
    {
        if(head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast)
        {
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        fast = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
   /* public ListNode detectCycle(ListNode head) {
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

            return fast;

        }
    }*/
}
