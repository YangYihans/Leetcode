package leetcode.List;
/**
 * @Author Yang
 * @Date 2021/3/24 15:04
 * @Description 160.相交链表
 * 找出两个单链表相交的节点
 */
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        // 如果相交会在相交点相遇，如果不相交会在尾端相遇/
        while(ptrA != ptrB){
            ptrA = ptrA != null ? ptrA.next : headB;
            ptrB = ptrB != null ? ptrB.next : headA;
        }
        return ptrA;
    }
}
