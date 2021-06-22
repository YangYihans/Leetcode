//package leetcode.List;
//
//import java.util.Stack;
//
///*
//力扣2.两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// */
//public class addTwoNumbersTest2 {
//    public static void main(String[] args) {
//        addTwoNumbersTest2 t1 = new addTwoNumbersTest2();
//        ListNode l1 = new ListNode(2);
//        l1.add(4);
//        l1.add(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.add(6);
//        l2.add(4);
//        ListNode res = t1.addTwoNumbers(l1,l2);
//        res.print();
//    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
//    {
//        Stack<Integer> stack = new Stack<>();
//        ListNode dummy = new ListNode(-1);
//        ListNode res = dummy;
//        int carry = 0;
//        while(l1 != null && l2 != null)
//        {
//            int temp = l1.val + l2.val + carry;
//            if(temp >= 10)
//            {
//                temp = temp % 10;
//                carry = 1;
//                res.next = new ListNode(temp);
//                res = res.next;
//            }
//            else
//            {
//                carry = 0;
//                res.next = new ListNode(temp);
//                res = res.next;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        while (l1 != null)
//        {
//            if(carry == 0)
//            {
//                res.next = new ListNode(l1.val);
//                res = res.next;
//            }
//            else
//            {
//                if(l1.val == 9)
//                {
//                    carry = 1;
//                    res.next = new ListNode(0);
//                    res = res.next;
//                }
//                else
//                {
//                    carry = 0;
//                    res.next = new ListNode(l1.val+1);
//                    res  = res.next;
//                }
//            }
//            l1 = l1.next;
//        }
//        while (l2 != null)
//        {
//            if(carry == 0)
//            {
//                res.next = new ListNode(l2.val);
//                res = res.next;
//            }
//            else
//            {
//                if(l2.val == 9)
//                {
//                    carry = 1;
//                    res.next = new ListNode(0);
//                    res = res.next;
//                }
//                else
//                {
//                    carry = 0;
//                    res.next = new ListNode(l2.val+1);
//                    res  = res.next;
//                }
//            }
//            l2 = l2.next;
//        }
//        if(carry == 1)
//        {
//            res.next = new ListNode(1);
//            res = res.next;
//            res = null;
//        }
//        else
//            res = null;
//
//        return dummy.next;
//    }
//}
