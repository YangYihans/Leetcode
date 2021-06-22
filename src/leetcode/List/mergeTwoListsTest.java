package leetcode.List;




public class mergeTwoListsTest {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String [] args)
    {
        mergeTwoListsTest t1 = new mergeTwoListsTest();
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode output = new ListNode(-1);
        ListNode pre = output;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                pre.next = l1;
                l1= l1.next;
            }
            else
            {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return output;
    }

}
