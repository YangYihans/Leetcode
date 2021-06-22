package leetcode.List;

import java.util.Comparator;
import java.util.PriorityQueue;
//合并k个有序链表
public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode res = new ListNode(-1);
        ListNode current = res;
        PriorityQueue<ListNode> queue = new PriorityQueue(20,new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2)
            {
                return l1.val-l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++)
        {
            while(lists[i] != null)
            {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        while(!queue.isEmpty())
        {
            ListNode temp = queue.poll();
            current.next = temp;
            current  = current.next;
        }
        current.next = null;
        return res.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}
