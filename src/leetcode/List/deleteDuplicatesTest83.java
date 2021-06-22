package leetcode.List;

public class deleteDuplicatesTest83 {
    public static void main(String[] args) {
        deleteDuplicatesTest83 t1 = new deleteDuplicatesTest83();
    }
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null)
            return null;
        ListNode current = head; //current和head指向的是同一个地址，current操作链表，最后返回是链表的头地址就是head。
        while(current != null && current.next != null)
        {
            if(current.val == current.next.val)
            {
                ListNode node = current.next;
                current.next = node.next;
                node.next = null; //删除野指针
            }
            else{
                current = current.next;
            }
        }
        return head;
    }
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }
}
