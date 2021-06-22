package leetcode.List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
141.环形链表
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class hasCycleTest141 {
    public static void main(String[] args) {
        hasCycleTest141 t1 = new hasCycleTest141();
    }
    public boolean hasCycle(ListNode head)
    {
        Set<ListNode> node = new HashSet<>();
        if(head == null)
        {
            return false;
        }
        while(head != null)
            {
            if(node.contains(head))
            {
                return true;
            }
            else
             {
                node.add(head);
            }
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle1(ListNode head)
    {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast)
        {
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
