package leetcode.List;
/*
力扣61：旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class rotateRightTest61 {
    public static void main(String[] args) {
        rotateRightTest61 t1 = new rotateRightTest61();
    }
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null || k == 0)
            return head;
        int len = 0;
        ListNode current = head;
        ListNode result = new ListNode(-1);
        ListNode resultPtr = result;
        ListNode tail = new ListNode(-1);
        ListNode tailPtr = tail;
        while(current != null)
        {
            len++;
            current = current.next;
        }
        int times = k % len;
        if(times == 0)
            return  head;
        current = head;
        for(int i = 0; i < len - times -1; i++)
        {
            tailPtr.next = current;
            tailPtr = tailPtr.next;
            current = current.next;
        }
        tailPtr.next = null;
        while(current != null)
        {
            resultPtr.next = current;
            resultPtr = resultPtr.next;
            current = current.next;
        }
        resultPtr.next = tail.next;
        return result.next;
    }
}
