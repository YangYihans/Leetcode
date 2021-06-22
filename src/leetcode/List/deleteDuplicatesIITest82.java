package leetcode.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
力扣82：删除排序链表中的重复元素II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class deleteDuplicatesIITest82 {
    public static void main(String[] args) {
        deleteDuplicatesIITest82 t1 = new deleteDuplicatesIITest82();
    }

    /**
     * 创建一个哑巴节点大大简化代码的复杂程度
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null && current.next.next != null)
        {
            if(current.next.val == current.next.next.val)
            {
                ListNode temp = current.next;
                while(temp != null && temp.next != null && temp.val == temp.next.val)
                {
                    temp = temp.next;
                }
                current.next = temp.next;
            }
            else
                current = current.next;
        }
        return dummy.next;
    }
}
