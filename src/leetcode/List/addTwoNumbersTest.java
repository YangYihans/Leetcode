//package leetcode.List;
//
//import java.util.Stack;
///*
//力扣445：两数相加II
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
//你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//思路：逆序处理一般都会用到栈。
// */
//public class addTwoNumbersTest {
//    public static void main(String[] args) {
//        addTwoNumbersTest t1 = new addTwoNumbersTest();
//        ListNode l1 = new ListNode(8);
//        l1.add(9);
//        l1.add(9);
//
//        ListNode l2 = new ListNode(2);
//        ListNode res = t1.addTwoNumbers(l1,l2);
//        res.print();
//    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
//    {
//        Stack<Integer> stack1 = new Stack<Integer>();
//        Stack<Integer> stack2 = new Stack<Integer>();
//        Stack<Integer> stack3 = new Stack<Integer>();
//        int len1 = 0;
//        int len2 = 0;
//        ListNode head1 = l1;
//        ListNode head2 = l2;
//        //两个while循环完成倒叙操作。
//        while(l1 != null)
//        {
//            stack1.push(l1.val);
//            l1 = l1.next;
//            len1++;
//        }
//        while(l2 != null)
//        {
//            stack2.push(l2.val);
//            l2 = l2.next;
//            len2++;
//        }
//        int carry = 0; // 进位标识符
//
//        while(!stack1.isEmpty() && !stack2.isEmpty())
//        {
//            int temp = stack1.pop() + stack2.pop() + carry;
//            if(temp >= 10)
//            {
//                carry = 1;
//                temp = temp % 10;
//            }
//            else
//            {
//                carry = 0;
//            }
//            stack3.push(temp);
//        }
//        //两个while完成较长的链表的继续操作
//        while(!stack1.isEmpty())
//        {
//            if(carry == 0)
//                stack3.push(stack1.pop());
//            else
//            {
//                if(stack1.peek() == 9)
//                {
//                    carry = 1;
//                    stack1.pop();
//                    stack3.push(0);
//                }
//                else
//                {
//                    carry = 0;
//                    stack3.push(stack1.pop()+1);
//                }
//            }
//        }
//        while(!stack2.isEmpty())
//        {
//            if(carry == 0)
//                stack3.push(stack2.pop());
//            else
//            {
//                if(stack2.peek() == 9)
//                {
//                    carry = 1;
//                    stack2.pop();
//                    stack3.push(0);
//                }
//                else
//                {
//                    carry = 0;
//                    stack3.push(stack2.pop()+1);
//                }
//            }
//        }
//        ListNode dummy = new ListNode(-1);
//        dummy.next = len1 > len2? head1 : head2;
//        ListNode current;
//        //如果最高位进位整体就要增加1.
//        if(carry == 1)
//        {
//            stack3.push(1);
//            current = dummy;
//            while(!stack3.isEmpty())
//            {
//                current.val = stack3.pop();
//                current = current.next;
//            }
//            return dummy;
//        }
//        current = dummy.next;
//        while (!stack3.isEmpty())
//        {
//            current.val = stack3.pop();
//            current = current.next;
//        }
//        return dummy.next;
//
//    }
//}
