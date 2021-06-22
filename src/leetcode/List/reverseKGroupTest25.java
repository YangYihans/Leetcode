package leetcode.List;

import java.util.List;
import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序
 */
public class reverseKGroupTest25 {
    public static void main(String[] args) {
        reverseKGroupTest25 t1 = new reverseKGroupTest25();
    }
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode current = head;
        ListNode next = null;
        dummy.next = head;
        int length = 0;
        while(head != null)
        {
            length++;
            head = head.next;
        }
        head = dummy.next;
        for(int i = 0 ; i < length/k; i++)
        {
            for(int j = 0; j < k - 1; j++)
            {
                next = current.next;
                current.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = current;
            current = pre.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroupI(ListNode head, int k){
        if(head == null){
            return null;
        }
        ListNode left = head, right = head;
        for(int i = 0; i < k; i++){
            if(right == null){
                return head;
            }
            right = right.next;
        }
        ListNode newHead = reverse(left, right);
        left.next = reverseKGroupI(right, k);
        return newHead;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode next = left;
        ListNode pre = null;
        ListNode current = left;
        while(current != right){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
