package leetcode.List;

public class sortList {
    public static void main(String[] args)
    {

    }
//    public ListNode sortList(ListNode head)
//    {
//        if(head == null || head.next == null)
//            return head;
//        ListNode p1 = head;
//        ListNode p2 = head;
//        //快慢指针 找到中点
//        while(p2.next != null && p2.next.next != null)
//        {
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        ListNode tail = p1;
//        p1 = p1.next;
//        tail.next = null;
//        /**
//         * 此时 tail是链表的前半段， p1是链表的后半段
//         */
//        //继续递归找到将左链表和右链表继续细分
//        ListNode L = sortList(head);
//        ListNode R = sortList(p1);
//        return merge(L,R);
//    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                current.next = l1;
                l1 = l1.next;
                current  = current.next;
            }
            else
            {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        if(l1 != null)
            current.next = l1;
        if(l2 != null)
            current.next = l2;
        current.next = null;
        return dummy.next;
    }


    /**
     * @Author Yang
     * @Date 2021/3/24 14:52
     * @Descriptio 148。排序链表
     */

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode rightHead = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeList(left, right);

    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current = left != null ? left : right;
        return dummy.next;
    }
}
