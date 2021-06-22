package leetcode.List;
/*
力扣86：分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
 */
public class partitionTest86 {
    public static void main(String[] args) {
        partitionTest86 t1 = new partitionTest86();

    }

    /**
     * 构造两个链表，一个存放小于x的数，一个存放大于等于x的数，最后将两个链表进行拼接
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode minList = new ListNode(0);
        ListNode minCur = minList;
        ListNode maxList = new ListNode(0);
        ListNode maxCur = maxList;
        while(head != null)
        {
            if(head.val < x)
            {
                minCur.next = head;
                minCur = minCur.next;
            }
            else
            {
                maxCur.next = head;
                maxCur = maxCur.next;
            }
            head =head.next;
        }
        minCur.next = maxList.next;
        maxCur.next = null;
        return minList.next;
    }
}
