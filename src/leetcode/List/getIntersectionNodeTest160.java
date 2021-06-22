package leetcode.List;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.List;

/*
160.相交链表
编写一个程序，找到两个单链表相交的起始节点。

 */
public class getIntersectionNodeTest160 {
    public static void main(String[] args) {
        getIntersectionNodeTest160 t1 = new getIntersectionNodeTest160();
    }

    /**
     * 统计两个链表的长度，做差让长的链表先走差值步，然后两个链表一起走，直到遇到相同位置返回。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA == null || headB == null)
            return null;
        ListNode currentA = headA;
        ListNode currentB = headB;
        int lenA = 0;
        int lenB = 0;
        while(currentA != null)
        {
            lenA++;
            currentA = currentA.next;
        }
        while(currentB != null)
        {
            lenB++;
            currentB = currentB.next;
        }
        int diff = 0;
        currentA = headA;
        currentB = headB;
        if(lenA > lenB)
        {
            diff = lenA - lenB;
            for(int i = 0; i < diff; i++)
            {
                currentA = currentA.next;
            }
            while(currentA != currentB)
            {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        else {
            diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                currentB = currentB.next;
            }
            while (currentA != currentB)
            {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return currentA;
    }
}
