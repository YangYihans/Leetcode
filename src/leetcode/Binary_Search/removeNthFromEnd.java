package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/3/31 16:40
 * @Description 19. 删除链表的倒数第 N 个结点
 * 双指针在链表上的应用
 *   1. 快慢指针判断是否有环
 *   2. 快慢指针判断环起始的节点
 *   3. 寻找链表的中点
 *   4. 删除倒数第N个链表
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
