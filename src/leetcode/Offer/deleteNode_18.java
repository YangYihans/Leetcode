package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/23 10:21
 * @Description 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 */
public class deleteNode_18 {
    public ListNode deleteNode(ListNode head, int val){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode dummy_cur = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                dummy_cur.next = cur.next;
                break;
            }
            cur = cur.next;
            dummy_cur = dummy_cur.next;
        }
        return dummy.next;
    }
}
