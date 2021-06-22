package leetcode.List;
/*
203:移除链表元素
删除链表中等于给定值 val 的所有节点。
 */
public class removeElementsTest203 {
    public static void main(String[] args) {
        removeElementsTest203 t1 = new removeElementsTest203();
    }

    /**
     * 设置一个哑巴节点，如果遇到相同的就直接用后一个元素替代这个相同的元素继续比较。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val)
    {
        if(head==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null &&current.next.next != null)
        {
            if(current.next.val == val)
            {
                current.next = current.next.next;
            }
            else
                current = current.next;
        }
        if(current.next != null && current.next.val == val)
            current.next = null;
        return dummy.next;
    }
}
