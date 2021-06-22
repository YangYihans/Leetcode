package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/23 10:46
 * @Description 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 快慢指针
 */
public class getKthFromEnd_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frontNode = head, behindNode = head;
        while (frontNode != null && k > 0) {
            frontNode = frontNode.next;
            k--;
        }

        while (frontNode != null) {

            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }
}
