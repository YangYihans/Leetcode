package leetcode.List;

public class removeNthFromEndTest19 {
    public static void main(String[] args) {
        removeNthFromEndTest19 t1 = new removeNthFromEndTest19();
    }

    /**
     * 链表问题head始终是指向的头结点，使用current来实际操作链表进行增删，最后返回head就是从头开始遍历链表
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head == null)
            return null;
        ListNode current = head;
        int len = 0;
        while(current != null) //统计链表的长度
        {
            len++;
            current = current.next;
        }
        if(n == len) //删除头结点的情况
            return head.next;
        current = head;
        if(n == 1) //删除尾节点的情况
        {
            for(int i = 0; i < len-1; i++)
            {
                if(i == len -2)
                {
                    current.next = null;
                    break;
                }
                current = current.next;
            }

        }
        else { //删除中间某个节点的情况
            for(int i = 0; i < len; i++)
            {
                if(i == len - n - 1)
                    current.next = current.next.next;
                else
                    current = current.next;

            }
        }

        return head;
    }
}
