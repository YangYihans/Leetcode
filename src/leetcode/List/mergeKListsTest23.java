package leetcode.List;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
合并k个链表
维护一个小根堆，从中取出数据即可。
 */
public class mergeKListsTest23 {
    public static void main(String[] args) {
        mergeKListsTest23 t1 = new mergeKListsTest23();

    }
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
    /*    Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof ListNode && o2 instanceof ListNode)
                {
                    return ((ListNode) o1).val-((ListNode) o2).val;
                }
                return 0;
            }
        };*/
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
/*        for(ListNode listNode : lists)
        {
            if(listNode  == null)
                continue;
            pq.add(listNode);
        }*/
        for(int i = 0; i < lists.length; i++)
        {
            while (lists[i]!= null)
            {
                pq.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();
            current.next = temp;
            current = current.next;
        }
        current = null;
        return dummy.next;
    }
}
