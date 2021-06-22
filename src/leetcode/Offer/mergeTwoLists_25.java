package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/23 11:32
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class mergeTwoLists_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
